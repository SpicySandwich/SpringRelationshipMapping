package com.test.SpringTest.DAO;

import com.test.SpringTest.ModelEnttity.Location;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationDAO extends CrudRepository<Location, Integer> {

}
