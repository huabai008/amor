package com.amor.core.base;

import java.util.List;

/**
 * 封装常用CRUD操作
 * 
 * @author huaba
 *
 * @param <Model>
 * @param <PK>
 */

public interface BaseMapper<Model, PK> {
	
	int insert(Model model);
	
	int deleteByPrimaryKey(PK id);
	
	Model selectByPrimaryKey(PK id);
	
	List<Model> selectAll();
	
	int updateByPrimaryKey(Model model);
}
