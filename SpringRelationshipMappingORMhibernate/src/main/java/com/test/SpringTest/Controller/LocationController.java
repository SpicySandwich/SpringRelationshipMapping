package com.test.SpringTest.Controller;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.ModelEnttity.Location;
import com.test.SpringTest.ModelEnttity.Users;
import com.test.SpringTest.Service.LocationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  "/location")
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping
	public List<Location> getAllLocation(){
		
		return locationService.getAllLocation();
	}
	
	@GetMapping("/{id}")
	public Optional<Location> getLocationbyid(@PathVariable Integer id){
		
		return locationService.getLocationid(id);
	}
	
	@GetMapping("/{id}/users")
	public List<Users>  getUSerByLocation(@PathVariable Integer id){
		
		Optional<Location> location = locationService.getLocationid(id);
		
		if (location.isPresent()) {
			
			return location.get().getUsers();
		
		}
		return null;
	} 
	
	 @PostMapping
	 public Location saveUsers(@RequestBody Location location) {
		 
		 return locationService.saveLocation(location);
	 }
	 
	 @PutMapping
 public Location updateUsers(@RequestBody Location location) {
		 
		 return locationService.updateLocation(location);
	 }
	 
	 @DeleteMapping("/{id}")
	 public void deleteUser(@PathVariable Integer  id) {
		 
		 locationService.deleteLocation(id);
	 }
	 

}
