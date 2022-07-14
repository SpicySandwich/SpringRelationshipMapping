package com.test.SpringTest.ModelEnttity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "id")
public class Users {
	
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String firstname;
	private String lastname;
	
	//@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id",insertable  =false, updatable  =false)
	private Location location;
	
	//@JsonManagedReference
	@OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
	private List<Posts> posts;
	private String email;
	private Integer location_id;
	

	
	
	

}
