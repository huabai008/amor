package com.amor.service;

import com.amor.core.base.BaseService;
import com.amor.orm.model.AUser;

public interface UserService extends BaseService<AUser, Integer>{
	
	AUser authentication(AUser user);
	
	AUser selectByName(String username);
}
