package com.amor.service;

import com.amor.orm.model.AProduct;

import java.util.List;
import java.util.Map;

/**
 * 产品信息提交服务
 * @author sicong.yang
 */
public interface ProductInfoService {
	
	int insertProductInfo(AProduct product);
	
	int updateProductInfo(AProduct product);
	
	int deleteProductInfo(Integer id);
	
	AProduct selectProductByID(Integer id);
	
	/**
	 * 获取产品信息字典
	 * @return Map<Integer, String> <code, label>
	 */
	Map<Integer, String> getBusinessDict(String dict_class);
	
	/**
	 * get paged product information
	 * @return List<AProduct> paged product information
	 */
	List<AProduct> queryProductByPage(Integer pageNum, Integer pageSize);
}
