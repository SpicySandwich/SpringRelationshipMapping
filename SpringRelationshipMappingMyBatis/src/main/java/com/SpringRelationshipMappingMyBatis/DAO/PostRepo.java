package com.SpringRelationshipMappingMyBatis.DAO;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Entity.Users;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PostRepo {
	
	@Select("SELECT id, firstname as firstname, lastname as lastname, location_id as location_id,  email as email FROM users WHERE id = #{users_id}")
	Users selectPostUsers();
	
	@Select("SELECT  id, details as details, post_date as postDate, users_id as users_id FROM posts  WHERE  id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="postDate", column="post_date"),
			@Result(property="name", column="name"),
			@Result(property="details", column="details"),
			@Result(property=" users_id", column=" users_id"),
			@Result(property="users", column="users_id", javaType=Users.class, one =@One(select="selectPostUsers"))
		})
	
	 public Posts findById(Integer id);
	
	
	@Select("select * from posts")
    public  List <Posts> findAll();

	
	@Insert("INSERT INTO posts(id, post_date,  details, users_id) " +
		      " VALUES (#{id}, #{postDate}, #{details}, #{users_id} )")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Posts  posts);
	
	@Delete("DELETE FROM posts WHERE id = #{id}")
	public int deleteById(Integer id);
	
	
	 @Update("Update posts set "
	 		+ "id=#{id}, " +
		        "post_date=#{postDate},"
		        + " details=#{details},"
		        + " users_id=#{users_id}")
		   void update(Posts  posts);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM posts WHERE id = #{id})")
	 boolean ifIDExist(Integer id);

}
