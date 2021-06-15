package com.softib.core.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.softib.core.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Query("SELECT u FROM User u WHERE u.email=:email")
    public User findUserByEmail(@Param("email")String email);
	
	@Query("SELECT u FROM User u WHERE u.username=:username")
    public User findUserByUsername(@Param("username")String username);
}
