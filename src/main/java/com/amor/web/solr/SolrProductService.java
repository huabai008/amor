package com.amor.web.solr;

import java.util.List;

import com.amor.orm.model.AProduct;
import com.amor.orm.model.PageForSolr;

public interface SolrProductService {
	void insert(AProduct product);
	
	void delete(Integer id);

	List<AProduct> query(String query);

	void optimize();

	PageForSolr<AProduct> getPage(PageForSolr<AProduct> page);
}
