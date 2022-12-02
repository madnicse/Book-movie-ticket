package com.movie.bookmovie.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.movie.bookmovie.entities.User;

public interface UserRepository extends CrudRepository<User,Integer> {
    
    //public Optional<User> findById(String id);
    public List<User>  findByName(String name);

    @Query("select u from User u where u.id =:n")
    public List<User> getUserById(@Param("n") int id);
    
}
