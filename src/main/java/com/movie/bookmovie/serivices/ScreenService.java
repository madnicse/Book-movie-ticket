package com.movie.bookmovie.serivices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.bookmovie.dao.ScreenRepository;
import com.movie.bookmovie.entities.Screen;

@Component
public class ScreenService {

    @Autowired
    ScreenRepository screenRepository;

    public List<Screen> getAllScreen(){

        List<Screen> screen=(List<Screen>)this.screenRepository.findAll();
        return screen;
    }
    
}
