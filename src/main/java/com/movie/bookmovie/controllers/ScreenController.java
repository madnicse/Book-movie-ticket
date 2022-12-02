package com.movie.bookmovie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmovie.entities.Screen;
import com.movie.bookmovie.serivices.ScreenService;

@RestController
public class ScreenController {
    @Autowired
    ScreenService screenService;

    @CrossOrigin(value = "http://localhost:4200/")
    @GetMapping("screens")
    public ResponseEntity<List<Screen>> getScreen(){

        List<Screen> screen=screenService.getAllScreen();
        if(screen.size()<=0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(screen));
    }
}
