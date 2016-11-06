package com.amor.core.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.stereotype.Service;

import com.amor.orm.model.Page;

@Service
public class SolrServiceImpl implements SolrService{
	
	@Resource
	private HttpSolrClient solrClient;
	
	/** 
     * 为多个文档对象的，某些属性建立索引 
     */  
    public <T> void addDocs(List<T> list, List<String> properties) {  
        if(null == list || list.size() == 0 ) {  
            return;  
        }  
        List<SolrInputDocument> docs = new ArrayList<SolrInputDocument>();  
        List<Field> fields = ReflectUtils.getAllFields(list.get(0).getClass());  
        for (T obj : list) {  
            SolrInputDocument doc = new SolrInputDocument();  
            for (Field field : fields) {  
                for (String property : properties) {  
                    if(property.equals(field.getName())) {  
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
        List<T> list = new ArrayList<T>();  
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
      
    @SuppressWarnings("unchecked")
	public <T> T queryById(String id, Class<?> entityClass) {  
        T obj = null;  
        try {  
            obj = (T) entityClass.newInstance();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        SolrQuery query = new SolrQuery();  
        query.setQuery("id:" + id);  
        QueryResponse response = null;  
        try {  
            response = solrClient.query(query);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        SolrDocumentList docs = response.getResults();  
        if(null == docs || docs.size() == 0) {  
            return null;  
        }  
        SolrDocument doc = docs.get(0);  
        ArrayList<Field> fields = ReflectUtils.getAllFields(obj.getClass());  
        for (Field field : fields) {  
            String propertyName = field.getName();  
            Object propertyValue = doc.getFieldValue(propertyName);  
            if(propertyValue == null)
            	continue;
            
            Class<?> propertyClass = field.getType();  
            ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);  
        }  
          
        return obj;  
    }  
    
    @SuppressWarnings("unchecked")
	public <T> T query(String queryStr, Class<?> entityClass) {  
        T obj = null;  
        try {  
            obj = (T) entityClass.newInstance();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        SolrQuery query = new SolrQuery();  
        query.setQuery(queryStr);  
        QueryResponse response = null;  
        try {  
            response = solrClient.query(query);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        SolrDocumentList docs = response.getResults();  
        if(null == docs || docs.size() == 0) {  
            return null;  
        }  
        SolrDocument doc = docs.get(0);  
        ArrayList<Field> fields = ReflectUtils.getAllFields(obj.getClass());  
        for (Field field : fields) {  
            String propertyName = field.getName();  
            Object propertyValue = doc.getFieldValue(propertyName);  
            if(propertyValue == null)
            	continue;
            
            Class<?> propertyClass = field.getType();  
            ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);  
        }  
          
        return obj;  
    }  
      
    /** 
     * solr获取的分页对象 
     *  
     */  
    @SuppressWarnings("unchecked")  
    public <T> Page<T> getPage(Page<T> page, SolrQuery solrQuery, Class<?> entityClass) {  
        solrQuery.setStart(page.getStartPage());
        solrQuery.setRows(page.getPageSize());
        QueryResponse queryResponse = null;  
        try {  
            queryResponse = solrClient.query(solrQuery);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        SolrDocumentList docs = queryResponse.getResults();  
        List<T> list = new ArrayList<T>(0);  
          
        for(SolrDocument doc : docs){  
            T obj = null;  
            try {  
                obj =  (T) entityClass.newInstance();  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
            ArrayList<Field> fields = ReflectUtils.getAllFields(obj.getClass());  
            for (Field field : fields) {  
                String propertyName = field.getName();  
                Object propertyValue = doc.getFieldValue(propertyName);
                if(propertyValue == null)
                	continue;
                
                Class<?> propertyClass = field.getType();  
                ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);  
            }  
            list.add(obj);  
        }  
        page.setTotalRecord(docs.size());  
        page.setResults(list);  
        return page;  
    }  
      
    /** 
     * 优化solr索引 
     */  
    public void optimize(String collection) {  
        try {  
            solrClient.optimize(collection);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
