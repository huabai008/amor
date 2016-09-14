package com.amor.service;

import java.util.List;

import com.amor.orm.model.ARole;

public interface RoleService {
	
	List<ARole> selectByParentId(int id);
	
	
}
