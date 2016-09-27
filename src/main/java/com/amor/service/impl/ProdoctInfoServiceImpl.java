package com.amor.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.ABusinessDictMapper;
import com.amor.orm.mapper.AProductMapper;
import com.amor.orm.model.ABusinessDict;
import com.amor.orm.model.AProduct;
import com.amor.service.ProductInfoService;
import com.github.pagehelper.PageHelper;

@Service
public class ProdoctInfoServiceImpl implements ProductInfoService {

	@Resource
	private AProductMapper productMapper;
	
	@Resource
	private ABusinessDictMapper dictMapper;
	
	@Override
	public int insertProductInfo(AProduct product) {
		return productMapper.insert(product);
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
}
