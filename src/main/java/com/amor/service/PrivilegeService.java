package com.amor.service;

import java.util.List;

import com.amor.orm.model.APrivilege;

public interface PrivilegeService {
	
	List<APrivilege> selectByParentId(int id);
	
	
}
