package com.movie.bookmovie.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.bookmovie.entities.Booking;
import com.movie.bookmovie.serivices.BookingSerivice;

@RestController
public class BookingController {
    
    @Autowired
    BookingSerivice bookingSerivice;

    @CrossOrigin(value = "http://localhost:4200/")
    @GetMapping("/bookings")
    public List<Booking> getAllBookings(){

        List<Booking> book=bookingSerivice.getALlBooking();

        return book;
        
    }
    @GetMapping("/bookings/{id}")
    public List<Booking> getAllBookingsById(@PathVariable("id")int id){

        List<Booking> book=bookingSerivice.getBookingById(id);

        return book;
        
    }
    @PostMapping(value="/bookings")
    public ResponseEntity<Booking> addMovieHandle(@RequestBody Booking booking){
        
        //User u=null;
        try{
           // System.out.println("In controlelr");
           // System.out.println(user.toString());
            this.bookingSerivice.createBooking(booking);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @DeleteMapping("/bookings/{id}")
    public ResponseEntity<Booking> deleteMovieHandle(@PathVariable("id") int id){
        
        try{
            this.bookingSerivice.deleteBooking(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
    @PutMapping("/bookings/{id}")
    public ResponseEntity<Booking> handleUpdateUser(@RequestBody Booking booking, @PathVariable("id")int id){
        
        try{
            this.bookingSerivice.updateBooking(booking, id);
            return ResponseEntity.status(HttpStatus.CREATED).build();

        }
        catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
