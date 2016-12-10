package com.amor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.ABusinessDictMapper;
import com.amor.orm.mapper.AProductImageMapper;
import com.amor.orm.mapper.AProductMapper;
import com.amor.orm.model.ABusinessDict;
import com.amor.orm.model.AProduct;
import com.amor.orm.model.AProductImage;
import com.amor.service.ProductInfoService;
import com.github.pagehelper.PageHelper;

@Service
public class ProdoctInfoServiceImpl implements ProductInfoService {

	@Resource
	private AProductMapper productMapper;
	
	@Resource
	private ABusinessDictMapper dictMapper;
	
	@Resource
	private AProductImageMapper prodImgMapper;
	
	@Override
	public int insertProductInfo(AProduct product) {
		int success = productMapper.insert(product);
		if (success > 0) {
			return product.getId();
		} else {
			return -1;
		}
	}

	@Override
	public Map<Integer, String> getBusinessDict(String dict_class) {
		Map<Integer, String> dict = new HashMap<Integer, String>();
		for (ABusinessDict dict_item : dictMapper.selectByDict(dict_class)) {
			dict.put(dict_item.getDictKey(), dict_item.getDictVal());
		}
		return dict;
	}

	@Override
	public List<AProduct> queryProductByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectAll();
	}

	@Override
	public AProduct selectProductByID(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateProductInfo(AProduct product) {
		return productMapper.updateByPrimaryKey(product);
	}

	@Override
	public int deleteProductInfo(Integer id) {
		return productMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insertProductImage(AProductImage prodImg) {
		return prodImgMapper.insert(prodImg);
	}

	@Override
	public List<AProductImage> selectProductImageByID(Integer productId) {
		return prodImgMapper.selectByProductId(productId);
	}

	@Override
	public int deleteProductImage(Integer id) {
		return prodImgMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int deleteProductImages(Integer productId) {
		return prodImgMapper.deleteByProductId(productId);
	}

	@Override
	public AProductImage selectProductImage(Integer id) {
		return prodImgMapper.selectByPrimaryKey(id);
	}

	@Override
	public AProductImage selectTopPriorityImage(Integer product_id) {
		return prodImgMapper.selectPriorityImage(product_id);
	}

	@Override
	public int updateProductImage(AProductImage pimg) {
		return prodImgMapper.updateByPrimaryKey(pimg);
	}
}
