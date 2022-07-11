package com.test.SpringTest.ModelEnttity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {
	
	@Id
	private Integer id;
	private String firstname;
	private String lastname;
	@ManyToOne
	private Location location;
	
	@OneToMany(mappedBy = "users")
	private List<Posts> posts;

}
