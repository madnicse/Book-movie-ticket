package com.movie.bookmovie.serivices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.movie.bookmovie.dao.BookingRepository;
import com.movie.bookmovie.entities.Booking;



@Component
public class BookingSerivice {
    
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getALlBooking(){

        List<Booking> bookings=(List<Booking>)this.bookingRepository.findAll();

        return bookings;
        
    }

    public List<Booking> getBookingById(int id){

        List<Booking> bookings=(List<Booking>)this.bookingRepository.findBookingById(id);

        return bookings;
        
    }
    public Booking createBooking( Booking booking){
       
        Booking booking1=this.bookingRepository.save(booking);
       // System.out.println("inside service");
       // System.out.println(user1.toString());
        return booking1;

    }
    public void deleteBooking(int id){
        bookingRepository.deleteById(id);
    }
    public void updateBooking(Booking booking,int id){
        booking.setId(id);
        bookingRepository.save(booking);
    }
    
}
