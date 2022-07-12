package com.test.SpringTest.DAO;

import java.util.List;

import com.test.SpringTest.ModelEnttity.Posts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostDAO extends CrudRepository<Posts,Integer> {
	
	List<Posts> findByUsersId(Integer id);

}
