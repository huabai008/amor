package com.amor.service;

import java.util.Set;

import com.amor.core.base.BaseService;
import com.amor.orm.model.AUser;

public interface UserService extends BaseService<AUser, Integer>{
	
	AUser selectByName(String username);
	
	void selectUserRole(AUser user);

	Set<Integer> selectRoleIdByUserId(Integer user_id);
}
