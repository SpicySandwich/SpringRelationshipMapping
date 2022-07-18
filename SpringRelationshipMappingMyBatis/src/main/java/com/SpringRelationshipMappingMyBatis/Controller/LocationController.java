package com.SpringRelationshipMappingMyBatis.Controller;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
