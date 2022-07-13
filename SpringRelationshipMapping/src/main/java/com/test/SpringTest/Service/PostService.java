package com.test.SpringTest.Service;

import java.util.List;
import java.util.Optional;

import com.test.SpringTest.DAO.PostDAO;
import com.test.SpringTest.ModelEnttity.Posts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	public List<Posts> getAllPost(){
		
		return (List<Posts>) postDAO.findAll();
	}
	
	public Optional<Posts> getbyidPost(Integer id){
		
		return postDAO.findById(id);
	}
	
	public List<Posts> getAllPostByUSer(Integer id){
		
		return postDAO.findByUsersId(id);
	}
	
	public Posts savePost(Posts posts) {
		
		return postDAO.save(posts);
	}
	
public Posts updatePost(Posts posts) {
		
		return postDAO.save(posts);
	}

     public void deletePost(Integer id) {
	
	  postDAO.deleteById(id);;
}

}
