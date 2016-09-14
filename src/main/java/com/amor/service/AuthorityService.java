package com.amor.service;

import com.amor.orm.model.AAuthority;

public interface AuthorityService {
	AAuthority selectAuthority(int id);
	
	AAuthority authentication(AAuthority auth);
	
	AAuthority authentication(String username, String password);
	
	AAuthority selectByName(String username);
	
}
