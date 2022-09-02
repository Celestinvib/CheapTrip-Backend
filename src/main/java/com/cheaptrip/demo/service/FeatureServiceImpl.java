package com.cheaptrip.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cheaptrip.demo.dao.IFeatureDAO;
import com.cheaptrip.demo.dto.Feature;

@Service
public class FeatureServiceImpl implements IFeatureService{

	@Autowired
	IFeatureDAO iFeatureDAO;
	
	@Override
	public List<Feature> listFeatures() {
		return iFeatureDAO.findAll();
	}

	@Override
	public Feature saveFeature(Feature feature) {
		return iFeatureDAO.save(feature);
	}

	@Override
	public Feature featureByID(Long id) {
		return iFeatureDAO.findById(id).get();
	}

	@Override
	public Feature updateFeature(Feature feature) {
		return iFeatureDAO.save(feature);
	}

	@Override
	public void deleteFeature(Long id) {
		iFeatureDAO.deleteById(id);
	}

}
