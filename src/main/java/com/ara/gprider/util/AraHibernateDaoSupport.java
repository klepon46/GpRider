package com.ara.gprider.util;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class AraHibernateDaoSupport extends HibernateDaoSupport{

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
}
