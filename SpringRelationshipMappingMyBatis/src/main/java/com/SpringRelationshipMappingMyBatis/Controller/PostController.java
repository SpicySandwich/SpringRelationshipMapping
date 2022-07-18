package com.SpringRelationshipMappingMyBatis.Controller;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Service.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

}
