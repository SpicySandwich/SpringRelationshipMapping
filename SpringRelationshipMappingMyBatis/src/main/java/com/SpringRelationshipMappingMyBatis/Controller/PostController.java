package com.SpringRelationshipMappingMyBatis.Controller;

import java.util.List;
import java.util.Optional;

import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Entity.Users;
import com.SpringRelationshipMappingMyBatis.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {
	
	
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Posts> postList(){
		 
		return postService.listPost();
	}
	
	@GetMapping("/{id}")
	public Posts getPost(@PathVariable Integer id) {
		return postService.findPost(id);
	}
	
	@GetMapping("/{id}/user")
	public Users getUserInPost(@PathVariable Integer id){
		
		Optional<Posts> posts = Optional.of(postService.findPost(id));
		
		if (posts.isPresent()) {
			return posts.get().getUsers();
		}
		return null;
	}

}
