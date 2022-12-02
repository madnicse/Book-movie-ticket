package com.movie.bookmovie.dao;

import org.springframework.data.repository.CrudRepository;

import com.movie.bookmovie.entities.Screen;

public interface ScreenRepository extends CrudRepository<Screen,Integer> {
    
}
