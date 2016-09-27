package com.amor.core.generic;

import java.util.List;

/**
 * 封装常用CRUD操作
 * 
 * @author huaba
 *
 * @param <Model>
 * @param <PK>
 */

public interface GenericMapper<Model, PK> {
	
	int insert(Model model);
	
	int deleteByPrimaryKey(PK id);
	
	Model selectByPrimaryKey(PK id);
	
	List<Model> selectAll();
	
	int updateByPrimaryKey(Model model);
}
