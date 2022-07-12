package com.test.SpringTest.DAO;

import java.util.List;

import com.test.SpringTest.ModelEnttity.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<Users, Integer> {
	
	List<Users> findByLocationId(Integer id);

}
