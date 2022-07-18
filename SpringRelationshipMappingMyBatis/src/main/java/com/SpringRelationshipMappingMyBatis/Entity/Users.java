package com.SpringRelationshipMappingMyBatis.Entity;

import java.util.List;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIdentityInfo(
//		  generator = ObjectIdGenerators.PropertyGenerator.class, 
//		  property = "id")
public class Users {
	

	private Integer id;
	private String firstname;
	private String lastname;
	private Integer location_id;
	private Location location;
	private List<Posts> posts;
	private String email;
	
	

	
	
	

}
