package com.amor.service;

import com.amor.orm.model.AProduct;
import com.amor.orm.model.AProductImage;

import java.util.List;
import java.util.Map;

/**
 * 产品信息提交服务
 * @author sicong.yang
 */
public interface ProductInfoService {
	
	/**
	 * 新增产品信息
	 * @param product model instance
	 * @return number of records inserted into database.
	 */
	int insertProductInfo(AProduct product);
	
	/**
	 * 新增产品图片
	 * @param prodImg
	 * @return
	 */
	int insertProductImage(AProductImage prodImg);
	
	/**
	 * 更新产品信息
	 * @param product
	 * @return
	 */
	int updateProductInfo(AProduct product);
	
	/**
	 * 删除产品信息
	 * @param id
	 * @return
	 */
	int deleteProductInfo(Integer id);
	
	/**
	 * 删除产品图片
	 * @param id
	 * @return
	 */
	int deleteProductImage(Integer id);
	
	/**
	 * 删除某一产品的所有图片
	 * @param productId
	 * @return
	 */
	int deleteProductImages(Integer productId);
	
	/**
	 * 获取产品信息
	 * @param id
	 * @return
	 */
	AProduct selectProductByID(Integer id);
	
	/**
	 * 获取产品的所有图片
	 * @param productId
	 * @return
	 */
	List<AProductImage> selectProductImageByID(Integer productId);
	
	/**
	 * 获取产品信息相关字段的字典
	 * @return Map<Integer, String> <code, label>
	 */
	Map<Integer, String> getBusinessDict(String dict_class);
	
	/**
	 * get paged product information
	 * @return List<AProduct> paged product information
	 */
	List<AProduct> queryProductByPage(Integer pageNum, Integer pageSize);
}
