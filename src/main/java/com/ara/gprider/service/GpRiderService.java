package com.ara.gprider.service;

import java.util.List;

import com.ara.gprider.bean.GpRider;

public interface GpRiderService {

	public void save(GpRider domain);
	public void delete(GpRider domain);
	public void update(GpRider domain);
	public List<GpRider> findAll();
	public GpRider findByName(String name);
	
}
