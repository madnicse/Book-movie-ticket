package com.movie.bookmovie.serivices;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.bookmovie.dao.MovieRepository;
import com.movie.bookmovie.entities.Movies;
@Component
public class MovieSerivices {
    

@Autowired
private MovieRepository movieRepository;


//private static List<Movies> m=new ArrayList<>();

   // static{
      // m.add(new Movies("m1","Madni","20222-04-22","eveamau"));
      // m.add(new Movies("m2","Madni","20222-04-22","eveamau"));
       
  //  }

public List<Movies> getAllMovies(){

    List<Movies> list=(List<Movies>)this.movieRepository.findAll();
    return  list;
}
public List<Movies> getMovieById(int id){
    List<Movies> movie=this.movieRepository.findMovieById(id);
    return movie;
}
public List<Movies> getMovieByShowCycle(String showCycle){

    List<Movies> movies=this.movieRepository.findByShowCycle(showCycle);
    return movies;

}
public Movies createMovie( Movies movies){
       
    Movies movies1=this.movieRepository.save(movies);
    //System.out.println("inside service");
    //System.out.println(user1.toString());
    return movies1;

}
public void deleteMovie(int id){
    movieRepository.deleteById(id);
}
public void updateMovie(Movies movies,int id){
    movies.setId(id);
    movieRepository.save(movies);
}


}
