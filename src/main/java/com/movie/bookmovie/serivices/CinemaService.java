package com.movie.bookmovie.serivices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.bookmovie.dao.CinemaRepository;
import com.movie.bookmovie.entities.Cinema;

@Component
public class CinemaService {
    
    @Autowired
    CinemaRepository cinemaRepository;

    public List<Cinema> getAllCinema(){

        List<Cinema> cinema=(List<Cinema>)this.cinemaRepository.findAll();

        return cinema;
    }
}
