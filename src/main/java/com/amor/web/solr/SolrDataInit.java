package com.amor.web.solr;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.model.AProduct;
import com.amor.service.ProductInfoService;

@Service
public class SolrDataInit {
	@Resource
	private ProductInfoService productService;

	@Resource
	private SolrProductService solrService;

	public void initAll(){
		List<AProduct> productList = productService.selectAll();
		for(AProduct product:productList){
			try{
			solrService.delete(product.getId());
			solrService.insert(product);
			}
			catch(Exception e){
				e.printStackTrace(); 
			}
		}
		solrService.optimize();
	}
}
