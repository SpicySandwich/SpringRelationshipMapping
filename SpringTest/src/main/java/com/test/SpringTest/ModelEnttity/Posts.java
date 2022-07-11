package com.test.SpringTest.ModelEnttity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Posts {
	
	@Id
	private Integer id;
	private LocalDateTime postDate;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users users;
	private String details;

}
