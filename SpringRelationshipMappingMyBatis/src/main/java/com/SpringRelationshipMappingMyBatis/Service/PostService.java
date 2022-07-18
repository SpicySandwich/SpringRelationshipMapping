package com.SpringRelationshipMappingMyBatis.Service;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.DAO.PostRepo;
import com.SpringRelationshipMappingMyBatis.Entity.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostRepo postRepo;
	
	public List<Posts> listPost(){
		
		return postRepo.findAll();
	}
	
	public Integer addPost(Posts posts) {
		
		return postRepo.insert(posts);
	}
	
	public Posts findPost(Integer id) {
		
		return postRepo.findById(id);
	}
	
	public void updatePost(Posts posts) {
		postRepo.update(posts);
	}
	
	public int deletePost(Integer id) {
		return postRepo.deleteById(id);
	}


}
