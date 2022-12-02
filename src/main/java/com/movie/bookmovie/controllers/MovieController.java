package com.movie.bookmovie.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmovie.entities.Movies;
import com.movie.bookmovie.serivices.MovieSerivices;

@RestController
public class MovieController {
    
    @Autowired
    private MovieSerivices movieSerivices;

    @CrossOrigin(value = "http://localhost:4200/")
    @GetMapping("/movies")
    public ResponseEntity<List<Movies>> getMovies(){

        List<Movies> movies=movieSerivices.getAllMovies();
        if(movies.size()<=0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(movies));
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<List<Movies>> getMoviesById(@PathVariable("id") int id){

        List<Movies> movie=movieSerivices.getMovieById(id);
        if(movie.size()<=0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(movie));
    }
    @GetMapping("/movies/showcycle/{show}")
    public ResponseEntity<List<Movies>> getMoviesByShowCycle(@PathVariable("show") String showCycle){

        List<Movies> movie=movieSerivices.getMovieByShowCycle(showCycle);
        if(movie.size()<=0){
             return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(movie));
    }

    @PostMapping(value="/movies")
    public ResponseEntity<Movies> addMovieHandle(@RequestBody Movies movie){
        
        //User u=null;
        try{
           // System.out.println("In controlelr");
           // System.out.println(user.toString());
            this.movieSerivices.createMovie(movie);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<Movies> deleteMovieHandle(@PathVariable("id") int id){
        
        try{
            this.movieSerivices.deleteMovie(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PutMapping("/movies/{id}")
    public ResponseEntity<Movies> handleUpdateUser(@RequestBody Movies movie, @PathVariable("id")int id){
        
        try{
            this.movieSerivices.updateMovie(movie, id);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}
