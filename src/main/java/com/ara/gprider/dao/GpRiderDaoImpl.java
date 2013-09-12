package com.ara.gprider.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ara.gprider.bean.GpRider;
import com.ara.gprider.util.AraHibernateDaoSupport;

@Repository
public class GpRiderDaoImpl extends AraHibernateDaoSupport implements GpRiderDao{
	
	@Autowired
	SessionFactory sessionFactory;

	public void save(GpRider domain) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().saveOrUpdate(domain);
	}

	public void delete(GpRider domain) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().delete(domain);
	}

	public void update(GpRider domain) {
		getHibernateTemplate().getSessionFactory().getCurrentSession().update(domain);
	}

	@SuppressWarnings("unchecked")
	public List<GpRider> findAll() {
		Query q = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("from GpRider");
		return q.list();
	}
	
	public GpRider findByName(String name) {
		String hql = "from GpRider where riderName = :riderName";
		Query q = getHibernateTemplate().getSessionFactory()
				.getCurrentSession().createQuery(hql);
		q.setString("riderName", name);
		return (GpRider) q.uniqueResult();
	}

}
