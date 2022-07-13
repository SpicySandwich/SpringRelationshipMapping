package com.test.SpringTest.Controller;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.ModelEnttity.Posts;
import com.test.SpringTest.ModelEnttity.Users;
import com.test.SpringTest.Service.PostService;

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
@RequestMapping(value =  "/post")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@GetMapping
	public List<Posts> getAllPost(){
		
		return postService.getAllPost();
	}

	@GetMapping("/{id}")
	public Optional<Posts> getbyifPost(@PathVariable Integer id){
		
		return postService.getbyidPost(id);
	}
	
	@GetMapping("/{id}/user")
	public Users  getAllPostbyUser(@PathVariable Integer id){
		
		Optional< Posts> post = postService.getbyidPost(id);
		if (post.isPresent()) {
			
			return post.get().getUsers();
		}
		return null;
	}
	
	@PostMapping
	public Posts savePost(@RequestBody Posts posts) {
		
		return postService.savePost(posts);
	}
	
	@PutMapping
     public Posts updatePost(@RequestBody Posts posts) {
		
		return postService.updatePost(posts);
	}
	
	@DeleteMapping("/{id}")
	public void deletePost(@PathVariable Integer id) {
		postService.deletePost(id);
	}
	
	
}
