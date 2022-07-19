package com.SpringRelationshipMappingMyBatis.Controller;

import java.util.List;
import java.util.Optional;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Entity.Users;
import com.SpringRelationshipMappingMyBatis.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<Users> userList(){
		return userService.listUser();
	}
	
	@GetMapping("/{id}")
	public Users findUser( @PathVariable Integer id) {
		
		return userService.findUser(id);
	}
	
	@GetMapping("/{id}/post")
	public List<Posts> getPostFromUser(@PathVariable Integer id){
		
		Optional<Users> uOptional = Optional.of(userService.findUser(id));
		if (uOptional.isPresent()) {
			return uOptional.get().getPosts();
		}
		return null;
	}
	
	@GetMapping("/{id}/location")
	public Location getLocationFromUser(@PathVariable Integer id){
		
		Optional<Users> uOptional = Optional.of(userService.findUser(id));
		if (uOptional.isPresent()) {
			return uOptional.get().getLocation();
		}
		return null;
	}
	
	

}
