package com.amor.web.solr;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.params.FacetParams;
import org.springframework.stereotype.Service;

import com.amor.core.base.BaseModel;
import com.amor.core.util.ReflectUtils;
import com.amor.orm.model.PageForSolr;

@Service
public class SolrBaseServiceImpl implements SolrBaseService {

	@Resource
	private SolrManager solrManager;

	private SolrClient solrClient;

	@Override
	public boolean hasCore() {
		return solrClient != null;
	}

	public void setSolrCore(String name) {
		this.solrClient = solrManager.solrClient(name);
	}

	/**
	 * 为多个文档对象的，某些属性建立索引
	 */
	public <T> void addDocs(List<T> list, List<String> properties) {
		if (null == list || list.size() == 0) {
			return;
		}
		List<SolrInputDocument> docs = new LinkedList<SolrInputDocument>();
		List<Field> fields = ReflectUtils.getAllFields(list.get(0).getClass());
		for (T obj : list) {
			SolrInputDocument doc = new SolrInputDocument();
			for (Field field : fields) {
				for (String property : properties) {
					if (property.equals(field.getName())) {
						doc.addField(property, ReflectUtils.invokeGetterMethod(obj, property));
					}
				}
			}
			docs.add(doc);
		}
		try {
			solrClient.add(docs);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 建立单个索引
	 */
	public <T> void addDoc(T obj, List<String> properties) {
		List<T> list = new LinkedList<T>();
		list.add(obj);
		addDocs(list, properties);
	}

	/**
	 * 将整个对象都添加到索引
	 */
	public <T> void addBean(T obj) {
		try {
			solrClient.addBean(obj);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加多个索引对象
	 */
	public <T> void addBeans(List<T> list) {
		try {
			solrClient.addBeans(list);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据id删除某条索引
	 */
	public void deleteById(String id) {
		try {
			solrClient.deleteById(id);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据查询语句删除索引
	 */
	public void deleteByQuery(String query) {
		try {
			solrClient.deleteByQuery(query);
			solrClient.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检索
	 */
	public QueryResponse solrQuery(SolrQuery query) {
		QueryResponse response = null;
		try {
			response = solrClient.query(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

	public QueryResponse solrQuery(String queryStr) {
		SolrQuery query = new SolrQuery();
		query.setQuery(queryStr);
		return solrQuery(query);
	}

	/**
	 * doc转成对象
	 */
	@SuppressWarnings("unchecked")
	private <T> T doc2obj(SolrDocument doc, Class<?> entityClass, List<String> properties) {
		T obj = null;
		try {
			obj = (T) entityClass.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Field> fields = ReflectUtils.getAllFields(obj.getClass());
		for (Field field : fields) {
			String propertyName = field.getName();
			if (properties != null && !properties.contains(propertyName))
				continue;
			if (!doc.containsKey(propertyName))
				continue;
			Object propertyValue = doc.getFieldValue(propertyName);
			if (propertyValue == null)
				continue;

			Class<?> propertyClass = field.getType();
			try {
				ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);
			} catch (Exception e) {
				System.out.println(propertyName + "/" + propertyValue + " " + propertyClass.getName() + "/"
						+ propertyValue.getClass());
				e.printStackTrace();
			}
		}
		return obj;
	}

	private <T> T doc2objOnlyId(SolrDocument doc, Class<?> entityClass) {
		List<String> pList = new ArrayList<>();
		pList.add("id");
		return doc2obj(doc, entityClass, pList);
	}

	private <T> T doc2obj(SolrDocument doc, Class<?> entityClass) {
		return doc2obj(doc, entityClass, null);
	}

	/**
	 * 通过id检索
	 */
	public <T> T queryById(Integer id, Class<?> entityClass) {
		return queryFirst("id:" + id, entityClass);
	}

	/**
	 * 检索返回第一条
	 */
	public <T> T queryFirst(String queryStr, Class<?> entityClass) {
		QueryResponse response = solrQuery(queryStr);
		SolrDocumentList docs = response.getResults();
		if (null == docs || docs.size() == 0) {
			return null;
		}
		SolrDocument doc = docs.get(0);
		return doc2obj(doc, entityClass);
	}

	/**
	 * 检索返回所有
	 */
	public <T> List<T> query(String queryStr, Class<?> entityClass) {
		QueryResponse response = solrQuery(queryStr);
		SolrDocumentList docs = response.getResults();
		if (null == docs || docs.size() == 0) {
			return null;
		}
		List<T> result = new LinkedList<>();
		for (SolrDocument doc : docs) {
			result.add(doc2objOnlyId(doc, entityClass));
		}
		return result;
	}

	/**
	 * solr获取的分页对象, 分面
	 * 
	 */
	@Override
	public <T> PageForSolr<T> getPage(PageForSolr<T> page, Class<?> entityClass) {
		SolrQuery query = page.getQuery();
		query.setStart((page.getPageNum() - 1) * page.getPageSize());
		query.setRows(page.getPageSize());
		query.setFacet(true);
		query.setFacetMinCount(1);
		for (String field : page.getFacetFields())
			query.addFacetField(field);
		query.setFacetSort(FacetParams.FACET_SORT_COUNT);

		QueryResponse queryResponse = null;
		try {
			queryResponse = solrClient.query(page.getQuery());
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		SolrDocumentList docs = queryResponse.getResults();
		List<T> list = new LinkedList<T>();
		for (SolrDocument doc : docs) {
			list.add(doc2objOnlyId(doc, entityClass));
		}
		page.setTotal(docs.getNumFound());
		page.setSize(docs.size());
		page.setList(list);
		page.refrashPageNum();

		List<FacetField> facet = queryResponse.getFacetFields();
		page.setFacetResult(facet);

		return page;
	}

	@Override
	public <T> PageForSolr<T> getPage(PageForSolr<T> page) {
		SolrQuery query = page.getQuery();
		query.setStart((page.getPageNum() - 1) * page.getPageSize());
		query.setRows(page.getPageSize());
		query.setFacet(true);
		query.setFacetMinCount(1);
		for (String field : page.getFacetFields())
			query.addFacetField(field);
		query.setFacetSort(FacetParams.FACET_SORT_COUNT);

		QueryResponse queryResponse = null;
		try {
			queryResponse = solrClient.query(query);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		List<Object> model = queryResponse.getBeans(Object.class);
		page.setModelResult(model);

		List<FacetField> facet = queryResponse.getFacetFields();
		page.setFacetResult(facet);

		return page;
	}

	/**
	 * 优化solr索引
	 */
	public void optimize() {
		try {
			solrClient.optimize();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
