package com.SpringRelationshipMappingMyBatis.Service;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.DAO.UserRepo;
import com.SpringRelationshipMappingMyBatis.Entity.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	

	@Autowired
	private UserRepo userRepo;
	
	public List<Users> listUser(){
		
		return userRepo.findAll();
	}
	
	public Integer addUser(Users users) {
		
		return userRepo.insert(users);
	}
	
	public Users findUser(Integer id) {
		
		return userRepo.findById(id);
	}
	
	public void updateUsern(Users users) {
		userRepo.update(users);
	}
	
	public int deleteUser(Integer id) {
		return userRepo.deleteById(id);
	}

}
