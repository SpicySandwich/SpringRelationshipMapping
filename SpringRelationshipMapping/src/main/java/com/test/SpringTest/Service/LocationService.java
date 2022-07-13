package com.test.SpringTest.Service;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.DAO.LocationDAO;
import com.test.SpringTest.ModelEnttity.Location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {
	
	@Autowired
	private LocationDAO locationDAO;
	
	public List<Location> getAllLocation(){
		
		return (List<Location>) locationDAO.findAll();
	}
	
	public Optional<Location> getLocationid(Integer id) {
		
		return locationDAO.findById(id);
	}
	
	public Location saveLocation(Location location) {
		
		return locationDAO.save(location);
	}
	
	public Location updateLocation(Location location) {
		return locationDAO.save(location);
	}
	
	public void deleteLocation(Integer id) {
		 locationDAO.deleteById(id);
	}


}
