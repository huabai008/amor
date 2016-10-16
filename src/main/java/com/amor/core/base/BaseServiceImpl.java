package com.amor.core.base;

import java.util.List;

/**
 * 定义常用的CRUD操作，对数据库的操作应该继承此类
 * 
 * @author huaba
 *
 * @param <Model> 
 * @param <PK> 
 */

public abstract class BaseServiceImpl<Model, PK> implements BaseService<Model, PK>{

	public abstract BaseMapper<Model, PK> getMapper();
	
	@Override
	public int insert(Model model) {
		return getMapper().insert(model);
	}

	@Override
	public int update(Model model) {
		return getMapper().updateByPrimaryKey(model);
	}

	@Override
	public int delete(PK id) {
		return getMapper().deleteByPrimaryKey(id);
	}

	@Override
	public Model selectById(PK id) {
		return getMapper().selectByPrimaryKey(id);
	}

	@Override
	public Model selectOne() {
		return null;
	}

	@Override
	public List<Model> selectList() {
		return null;
	}

}
