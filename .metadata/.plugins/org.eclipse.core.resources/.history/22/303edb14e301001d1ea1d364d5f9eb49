package com.test.SpringTest.ModelEnttity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
		generator = ObjectIdGenerators.PropertyGenerator.class, 
		property = "id")
public class Users {
	
	@Id
	private Integer id;
	private String firstname;
	private String lastname;
	@ManyToOne
	@JoinColumn(name = "location_id")
	private Location location;
	
	@OneToMany(mappedBy = "users")
	private List<Posts> posts;
	private String email;

}
