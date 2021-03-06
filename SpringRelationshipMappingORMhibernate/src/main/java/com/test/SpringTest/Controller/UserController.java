package com.test.SpringTest.Controller;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.ModelEnttity.Location;
import com.test.SpringTest.ModelEnttity.Posts;
import com.test.SpringTest.ModelEnttity.Users;
import com.test.SpringTest.Service.UserService;

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
@RequestMapping(value =  "/user")
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	@GetMapping
	public List<Users> getUsers() {
		
		return userService.getAllusers();
	}
	
	@GetMapping("/{id}")
	public Optional<Users> getbyId(@PathVariable Integer id) {
		
		return userService.getbyId(id);
	}
	
	@GetMapping("/{id}/post")
	public List<Posts> getPostbyUsers(@PathVariable Integer id){
		
		Optional<Users>  user = userService.getbyId(id);
		
		if (user.isPresent()) {
			
			return user.get().getPosts();
	
		}
		return null;
	}
	
	@GetMapping("/{id}/location")
	public Location getLocationByUsers(@PathVariable Integer id){
		
		Optional<Users> user = userService.getbyId(id);
		
		if (user.isPresent()) {
			return  user.get().getLocation();
		}
		return null;
	}
	
	@PostMapping
	public Users saveUsers(@RequestBody Users users) {
		
		return userService.saveUsers(users);
	}
	
	@PutMapping
   public Users updayeUsers(@RequestBody Users users) {
		
		return userService.updateUsers(users);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUsers(@PathVariable Integer id) {
		userService.deleteUsers(id);
	}
	
	

}
