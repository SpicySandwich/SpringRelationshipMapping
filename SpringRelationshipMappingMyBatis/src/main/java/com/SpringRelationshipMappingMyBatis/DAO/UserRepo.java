package com.SpringRelationshipMappingMyBatis.DAO;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Entity.Posts;
import com.SpringRelationshipMappingMyBatis.Entity.Users;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserRepo {
	
	@Select("SELECT  id, details as details, post_date as postDate, users_id as users_id FROM posts WHERE users_id = #{id}")
	List<Posts> selectUserPosts();
	
	@Select("SELECT id as id, name as name FROM location WHERE id = #{location_id}")
  Location  selectUserLocation();
	
	@Select("SELECT id, firstname as firstname, lastname as lastname, location_id as location_id,  email as email FROM users")
	@Results(value = {
		@Result(property="id", column="id"),
		@Result(property="firstname", column="firstname"),
		@Result(property="lastname", column="lastname"),
		@Result(property="location_id", column="location_id"),
		@Result(property="email", column="email"),
		@Result(property="location", column="location_id", javaType=Location.class, one=@One(select="selectUserLocation")),
		@Result(property="posts", column="id", javaType=List.class, many=@Many(select="selectUserPosts"))
	})
	
    public  List <Users> findAll();

	@Select("SELECT id, firstname as firstname, lastname as lastname, location_id as location_id,  email as email FROM users  WHERE  id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="firstname", column="firstname"),
			@Result(property="lastname", column="lastname"),
			@Result(property="location_id", column="location_id"),
			@Result(property="email", column="email"),
			@Result(property="location", column="location_id", javaType=Location.class, one=@One(select="selectUserLocation")),
			@Result(property="posts", column="id", javaType=List.class, many=@Many(select="selectUserPosts"))
		})
	 public Users findById(Integer id);

	@Insert("INSERT INTO users(id,  firstname, lastname,location_id,email) " +
		      " VALUES (#{id}, #{firstname}, #{lastname}, #{location_id}, #{email} )")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Users  users);
	
	@Delete("DELETE FROM users WHERE id = #{id}")
	public int deleteById(Integer id);
	

	
	 @Update("Update users set "
	 		+ "id=#{id}, " +
		        "firstname=#{firstname},"
		        + " lastname=#{lastname},"
		        + " location_id=#{location_id},"
		        + " email=#{email}")
		   void update(Users  productEntity);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM users WHERE id = #{id})")
	 boolean ifIDExist(Integer id);

}
