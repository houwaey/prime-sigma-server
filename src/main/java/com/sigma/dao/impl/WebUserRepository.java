package com.sigma.dao.impl;

import org.springframework.stereotype.Repository;

import com.sigma.abstracts.AbstractHibernateDao;
import com.sigma.dao.UserDao;
import com.sigma.model.WebUser;

@Repository
public class WebUserRepository extends AbstractHibernateDao<WebUser> implements UserDao<WebUser> {

	public WebUserRepository() {
		super();
		setClazz(WebUser.class);
	}
	
}
