package com.ara.gprider.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ara.gprider.bean.GpRider;
import com.ara.gprider.dao.GpRiderDao;

@Service("gpRider")
@Transactional
public class GpRiderServiceImpl implements GpRiderService{

	@Autowired
	GpRiderDao gpRiderDao;
	
	public void save(GpRider domain) {
		gpRiderDao.save(domain);
	}

	public void delete(GpRider domain) {
		gpRiderDao.delete(domain);
	}

	public void update(GpRider domain) {
		gpRiderDao.update(domain);
	}
	
	public List<GpRider> findAll() {
		return gpRiderDao.findAll();
	}

	public GpRider findByName(String name) {
		return gpRiderDao.findByName(name);
	}

}
