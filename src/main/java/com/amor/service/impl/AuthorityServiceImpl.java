package com.amor.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.amor.orm.mapper.AAuthorityMapper;
import com.amor.orm.model.AAuthority;
import com.amor.service.AuthorityService;

@Service
public class AuthorityServiceImpl implements AuthorityService{

	@Resource
	private AAuthorityMapper authorityMapper;
	
	@Override
	public AAuthority selectAuthority(int id) {
		return authorityMapper.selectByPrimaryKey(id);
	}
	
	@Override
	public AAuthority authentication(AAuthority auth){
		return authorityMapper.authentication(auth);
	}

	@Override
	public AAuthority authentication(String username, String password) {
		AAuthority auth = new AAuthority();
		auth.setUsername(username);
		auth.setPassword(password);
		return authorityMapper.authentication(auth);
	}

	@Override
	public AAuthority selectByName(String username) {
		return authorityMapper.selectByName(username);
	}
}
