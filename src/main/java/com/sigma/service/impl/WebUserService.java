package com.sigma.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigma.abstracts.AbstractHibernateService;
import com.sigma.dao.UserDao;
import com.sigma.interfaces.Operations;
import com.sigma.model.WebUser;
import com.sigma.service.UserService;

@Service
@Transactional
public class WebUserService extends AbstractHibernateService<WebUser> implements UserService<WebUser> {

	@Autowired
	private UserDao<WebUser> dao;
	
	public WebUserService() {
		super();
	}
	
	@Override
	protected Operations<WebUser> getDao() {
		return dao;
	}

}
