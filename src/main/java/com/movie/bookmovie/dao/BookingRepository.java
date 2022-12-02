package com.movie.bookmovie.dao;

import java.util.List;

import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import com.movie.bookmovie.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking,Integer>{

    public List<Booking> findBookingById(int a);
    
    
}
