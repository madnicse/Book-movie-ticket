package com.movie.bookmovie.serivices;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.movie.bookmovie.dao.UserRepository;
import com.movie.bookmovie.entities.User;

@Component
public class UserServices {
    
    @Autowired
    UserRepository userRepository;

    public List<User> getAllUser(){
        List<User> list=(List<User>)this.userRepository.findAll();  
        return list;
    }

    public List<User> getUser(int id){
        List<User> user=userRepository.getUserById(id);
        return user;
    }
    public List<User> getUserByName(String name){
        List<User> users=userRepository.findByName(name);
        return users;
    }
    public User createUser( User user){
       
        User user1=this.userRepository.save(user);
        System.out.println("inside service");
        System.out.println(user1.toString());
        return user1;

    }
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }
    public void updateUser(User user,int id){
        user.setId(id);
        userRepository.save(user);
    }


   
    }

