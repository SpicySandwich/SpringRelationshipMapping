package com.SpringRelationshipMappingMyBatis.DAO;

import java.util.List;

import com.SpringRelationshipMappingMyBatis.Entity.Location;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface LocationRepo {
	
	
	@Select("select * from location")
    public  List <Location> findAll();

	
	@Insert("INSERT INTO location(id,  name) " +
		      " VALUES (#{id}, #{name})")
@Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
	public int insert(Location  location);
	
	@Delete("DELETE FROM location WHERE id = #{id}")
	public int deleteById(Integer id);
	
	@Select("SELECT * FROM location  WHERE  id = #{id}")
	 public Location findById(Integer id);
	
	 @Update("Update location "
	 		+ "id=#{id}, " +
		        "name=#{name} ")
		   void update(Location  location);

	 
	 @Select("SELECT EXISTS(SELECT 1 FROM location WHERE id = #{id})")
	 boolean ifIDExist(Integer id);

}
