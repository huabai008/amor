package com.amor.web.solr;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

import com.amor.core.util.ReflectUtils;
import com.amor.orm.model.Page;

public class SolrUtils {
	 /** 
     * 为多个文档对象的，某些属性建立索引 
     * 
     * @date 2015-8-30 下午5:33:29 
     * @param list 
     * @param properties 
     * @param solrClient 
     */  
    public static <T> void addDocs(List<T> list, List<String> properties, SolrClient solrClient) {  
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
     * 
     * @param <T> 
     * @date 2015-8-30 下午5:33:58 
     * @param student 
     * @param properties 
     */  
    public static <T> void addDoc(T obj, List<String> properties, SolrClient solrClient) {  
        List<T> list = new ArrayList<T>();  
        list.add(obj);  
        addDocs(list, properties, solrClient);  
    }  
      
    /** 
     * 将整个对象都添加到索引 
     * @author wuyw 
     * @param <T> 
     * @date 2015-8-30 下午5:35:34 
     * @param student 
     */  
    public static <T> void addBean(T obj, SolrClient solrClient) {  
        try {  
            solrClient.addBean(obj);  
            solrClient.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 添加多个索引对象 
     * 
     * @param <T> 
     * @date 2015-8-30 下午5:36:37 
     * @param students 
     */  
    public static <T> void addBeans(List<T> list, SolrClient solrClient) {  
        try {  
            solrClient.addBeans(list);  
            solrClient.commit();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /** 
     * 根据id删除某条索引 
     *  
     * @date 2015-8-30 下午5:37:46 
     * @param id 
     */  
    public static void deleteById(String id, SolrClient solrClient) {  
        try {  
            solrClient.deleteById(id);  
            solrClient.commit();  
        } catch (Exception e) {  
           e.printStackTrace();  
        }  
    }  
      
    /** 
     * 根据查询语句删除索引 
     * 
     * @date 2015-8-30 下午5:38:46 
     * @param query 
     */  
    public static void deleteByQuery(String query, SolrClient solrClient) {  
        try {  
            solrClient.deleteByQuery(query);  
            solrClient.commit();  
        } catch (Exception e) {  
           e.printStackTrace();  
        }  
    }  
      
    @SuppressWarnings("unchecked")  
    public static <T> T queryById(String id, Class<?> entityClass, SolrClient solrClient) {  
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
            String propertyValue = (String) doc.getFieldValue(propertyName);  
            Class<?> propertyClass = field.getType();  
            if(propertyClass.equals(Integer.class)) {  
                Integer value = Integer.valueOf(propertyValue);  
                ReflectUtils.setFieldValue(obj, propertyClass, propertyName, value);  
            } else {  
                ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);  
            }  
        }  
          
        return obj;  
    }  
      
    /** 
     * solr获取的分页对象 
     *  
     * @param <T> 
     * @date 2015-8-30 下午5:39:36 
     * @param page 
     * @param solrQuery 里面封装了查询对象的条件 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> Page<T> getPage(Page<T> page, SolrQuery solrQuery, SolrClient solrClient, Class<?> entityClass) {  
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
                String propertyValue = (String) doc.getFieldValue(propertyName);  
                Class<?> propertyClass = field.getType();  
                if(propertyClass.equals(Integer.class)) {  
                    Integer value = Integer.valueOf(propertyValue);  
                    ReflectUtils.setFieldValue(obj, propertyClass, propertyName, value);  
                } else {  
                    ReflectUtils.setFieldValue(obj, propertyClass, propertyName, propertyValue);  
                }  
            }  
            list.add(obj);  
        }  
        page.setTotalRecord(docs.size());  
        page.setResults(list);  
        return page;  
    }  
      
    /** 
     * 优化solr索引 
     * 
     * @date 2015-8-31 上午12:02:49 
     * @param solrClient 
     */  
    public static void optimize(String collection, SolrClient solrClient) {  
        try {  
            solrClient.optimize(collection);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
