package com.amor.web.solr;

import java.util.List;

import com.amor.orm.model.PageForSolr;

public interface SolrBaseService {
	public boolean hasCore();
	
	public void setSolrCore(String corename);
	
	public <T> void addDocs(List<T> list, List<String> properties);  
      
    public <T> void addDoc(T obj, List<String> properties);  
      
    public <T> void addBean(T obj);  
      
    public <T> void addBeans(List<T> list);  
      
    public void deleteById(String id);  
      
    public void deleteByQuery(String query);  
    
    public <T> T queryById(Integer id, Class<?> entityClass);
    
    public <T> T queryFirst(String query, Class<?> entityClass);
    
    public <T> List<T> query(String query, Class<?> entityClass);
    
    public <T> PageForSolr<T> getPage(PageForSolr<T> page, Class<?> entityClass);  
      
    public void optimize();

	public <T> PageForSolr<T> getPage(PageForSolr<T> page);  
}
