package com.SpringRelationshipMappingMyBatis.Controller;

import java.util.List;
import java.util.Optional;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Entity.Users;
import com.SpringRelationshipMappingMyBatis.Service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping
	public List<Location> listLocations(){
		
	return	locationService.listLocation();
	}
	
	@GetMapping("/{id}")
	public Location getLocation(@PathVariable Integer id) {
		return locationService.findLocation(id);
	}
	
	@GetMapping("/{id}/user")
	public List<Users> getUsersInLocation(@PathVariable Integer id){
		
		Optional<Location> location = Optional.of(locationService.findLocation(id));
		if (location.isPresent()) {
			
			return location.get().getUsers();
		}
		return null;
	}
}
