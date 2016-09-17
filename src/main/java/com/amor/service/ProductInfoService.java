package com.amor.service;

import com.amor.orm.model.AProduct;
import java.util.Map;

/**
 * 产品信息提交服务
 * @author sicong.yang
 */
public interface ProductInfoService {
	
	int insertProductInfo(AProduct product);
	
	/**
	 * 获取产品信息字典
	 * @author sicong.yang
	 */
	Map<Integer, String> getBusinessDict(String dict_class);
}
