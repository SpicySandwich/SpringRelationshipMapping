package com.SpringRelationshipMappingMyBatis.DAO;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Location;
import com.SpringRelationshipMappingMyBatis.Entity.Users;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LocationRepo {
	
	
	@Select("SELECT id, firstname as firstname, lastname as lastname, location_id as location_id,  email as email FROM users WHERE location_id = #{id}")
	List<Users> selectLocationUsers();
	
	@Select("SELECT id, name as name FROM location WHERE  id = #{id}")
	@Results(value = {
			@Result(property="id", column="id"),
			@Result(property="name", column="name"),
			@Result(property="users", column="id", javaType=List.class, many=@Many(select="selectLocationUsers"))
		})
	
	 public Location findById(Integer id);
	
	
	@Select("select * from location")
    public  List <Location> findAll();

	
	@Insert("INSERT INTO location(id,  name) " +
		      " VALUES (#{id}, #{name})")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Location  location);
	
	@Delete("DELETE FROM location WHERE id = #{id}")
	public int deleteById(Integer id);
	

	
	 @Update("Update location "
	 		+ "id=#{id}, " +
		        "name=#{name} ")
		   void update(Location  location);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM location WHERE id = #{id})")
	 boolean ifIDExist(Integer id);

}
