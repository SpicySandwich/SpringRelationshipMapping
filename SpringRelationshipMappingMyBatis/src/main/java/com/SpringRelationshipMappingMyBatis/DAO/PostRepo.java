package com.SpringRelationshipMappingMyBatis.DAO;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Posts;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface PostRepo {
	
	@Select("select * from posts")
    public  List <Posts> findAll();

	
	@Insert("INSERT INTO posts(id, post_date,  details, users_id) " +
		      " VALUES (#{id}, #{postDate}, #{details}, #{users_id} )")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Posts  posts);
	
	@Delete("DELETE FROM posts WHERE id = #{id}")
	public int deleteById(Integer id);
	
	@Select("SELECT * FROM posts  WHERE  id = #{id}")
	 public Posts findById(Integer id);
	
	 @Update("Update posts set "
	 		+ "id=#{id}, " +
		        "post_date=#{postDate},"
		        + " details=#{details},"
		        + " users_id=#{users_id}")
		   void update(Posts  posts);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM posts WHERE id = #{id})")
	 boolean ifIDExist(Integer id);

}
