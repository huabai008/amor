package com.amor.core.util;

import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import com.amor.orm.model.Page;

public interface SolrService {
	public <T> void addDocs(List<T> list, List<String> properties);  
      
    public <T> void addDoc(T obj, List<String> properties);  
      
    public <T> void addBean(T obj);  
      
    public <T> void addBeans(List<T> list);  
      
    public void deleteById(String id);  
      
    public void deleteByQuery(String query);  
      
    public <T> T queryById(String id, Class<?> entityClass);
    
    public <T> T query(String query, Class<?> entityClass);
    
    /**
     * 待定
     * @param page
     * @param solrQuery
     * @param entityClass
     * @return
     */
    public <T> Page<T> getPage(Page<T> page, SolrQuery solrQuery, Class<?> entityClass);  
      
    public void optimize(String collection);  
}
