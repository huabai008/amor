package com.amor.web.solr;

import org.apache.solr.client.solrj.SolrClient;

public interface SolrManager {
	public SolrClient solrClient(String name);
}
