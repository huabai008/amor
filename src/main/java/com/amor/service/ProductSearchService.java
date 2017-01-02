package com.amor.service;

import com.amor.orm.model.AProduct;
import com.amor.orm.model.PageForSolr;

/**
 * 产品信息查询服务
 * @author sicong.yang
 */
public interface ProductSearchService {
	PageForSolr<AProduct> serarchAllByPage(PageForSolr<AProduct> page);
	
	AProduct serarchDeatil(Integer id);
}
