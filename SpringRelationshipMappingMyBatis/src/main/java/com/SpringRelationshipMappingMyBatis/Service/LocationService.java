package com.SpringRelationshipMappingMyBatis.Service;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.DAO.LocationRepo;
import com.SpringRelationshipMappingMyBatis.Entity.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepo locationRepo;
	
	public List<Location> listLocation(){
		
		return locationRepo.findAll();
	}
	
	public Integer addLocation(Location location) {
		
		return locationRepo.insert(location);
	}
	
	public Location findLocation(Integer id) {
		
		return locationRepo.findById(id);
	}
	
	public void updateLocation(Location location) {
		 locationRepo.update(location);
	}
	
	public int deleteLocation(Integer id) {
		return locationRepo.deleteById(id);
	}

}
