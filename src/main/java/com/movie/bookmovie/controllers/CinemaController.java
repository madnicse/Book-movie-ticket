package com.movie.bookmovie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmovie.entities.Cinema;
import com.movie.bookmovie.serivices.CinemaService;

@RestController
public class CinemaController {
    
    @Autowired
    CinemaService cinemaService;

    @CrossOrigin(value = "http://localhost:4200/")
   @GetMapping("cinemas")
    public ResponseEntity<List<Cinema>> getCinema(){

        List<Cinema> cinema=cinemaService.getAllCinema();
        if(cinema.size()<=0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(cinema));
    }

}
