package com.amor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.ABusinessDictMapper;
import com.amor.orm.model.AProduct;
import com.amor.orm.model.PageForSolr;
import com.amor.service.ProductInfoService;
import com.amor.service.ProductSearchService;
import com.amor.web.solr.SolrProductService;
import com.github.pagehelper.PageInfo;

@Service
public class ProductSearchServiceImpl implements ProductSearchService {

	@Resource
	private ProductInfoService productService;

	@Resource
	private ABusinessDictMapper dictMapper;

	@Resource
	private SolrProductService solrService;

	@Override
	public PageForSolr<AProduct> serarchAllByPage(PageForSolr<AProduct> page) {
		return solrService.getPage(page);
	}

	@Override
	public AProduct serarchDeatil(Integer id) {
		return productService.selectProductByID(id);
	}
}
