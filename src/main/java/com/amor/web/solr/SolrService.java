package com.amor.web.solr;

import java.util.List;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.QueryResponse;

import com.amor.orm.model.Page;

public interface SolrService {
	public void setSolrCore(String corename);
	
	public <T> void addDocs(List<T> list, List<String> properties);  
      
    public <T> void addDoc(T obj, List<String> properties);  
      
    public <T> void addBean(T obj);  
      
    public <T> void addBeans(List<T> list);  
      
    public void deleteById(String id);  
      
    public void deleteByQuery(String query);  
    
    public QueryResponse solrQuery(String queryStr);
      
    public <T> T queryById(Integer id, Class<?> entityClass);
    
    public <T> T queryFirst(String query, Class<?> entityClass);
    
    public <T> List<T> query(String query, Class<?> entityClass);
    
    public List<FacetField> queryFacet(String queryStr);
    
    public <T> Page<T> getPage(Page<T> page, SolrQuery solrQuery, Class<?> entityClass);  
      
    public void optimize(String collection);  
}
