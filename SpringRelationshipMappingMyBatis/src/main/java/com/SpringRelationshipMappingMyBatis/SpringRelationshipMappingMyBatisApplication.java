package com.SpringRelationshipMappingMyBatis;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Entity.Users;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MappedTypes({Location.class,Posts.class,Users.class})
@MapperScan("com.SpringRelationshipMappingMyBatis.DAO")
public class SpringRelationshipMappingMyBatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRelationshipMappingMyBatisApplication.class, args);
	}

}
