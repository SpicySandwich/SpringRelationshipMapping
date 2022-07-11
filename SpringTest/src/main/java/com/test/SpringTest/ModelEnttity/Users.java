package com.test.SpringTest.ModelEnttity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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

}
