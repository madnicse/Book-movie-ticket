package com.movie.bookmovie.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.apache.catalina.connector.Response;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmovie.dao.UserRepository;
import com.movie.bookmovie.entities.User;
import com.movie.bookmovie.serivices.UserServices;

@RestController
public class UserController {
    
    @Autowired
    UserServices userServices;
    @CrossOrigin(value = "http://localhost:4200/")
    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUser(){

        List<User> list=userServices.getAllUser();
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));

    }
    @GetMapping("/users/{id}")
    public ResponseEntity<List<User>> getUserByID(@PathVariable("id") int id){

    List<User> user=userServices.getUser(id);
    if(user.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
        
    return ResponseEntity.of(Optional.of(user));

    }
    //new user entry
    @PostMapping(value="/users")
    public ResponseEntity<User> addUser(@RequestBody User user){
        
        //User u=null;
        try{
            System.out.println("In controlelr");
            System.out.println(user.toString());
            this.userServices.createUser(user);


            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        
        try{
            this.userServices.deleteUser(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PutMapping("/users/{id}")
    public ResponseEntity<User> handleUpdateUser(@RequestBody User user, @PathVariable("id")int id){
        
        try{
            this.userServices.updateUser(user, id);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
        
}
