package com.amor.web.solr;

import java.util.HashMap;
import java.util.Map;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SolrManagerImpl implements SolrManager{
	@Value("${solr.url}")
	private String solrUrl;
	
	private Map<String, SolrClient> map = new HashMap<>(); 
	
	@Override
	public SolrClient solrClient(String name){
		if(map.containsKey(name)){
			return map.get(name);
		}else{
			SolrClient client = createClient(name);
			map.put(name, client);
			return client;
		}
	}
	
	@SuppressWarnings("deprecation")
	private SolrClient createClient(String name){
		return new HttpSolrClient(solrUrl + name);
	}
}
