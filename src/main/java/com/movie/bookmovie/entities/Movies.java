package com.movie.bookmovie.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="movies")
public class Movies {
    
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
   private int id;
    String title;

    @Column(name="release_date")
  private  String releaseDate;

    @Column(name="show_cycle")
   private String showCycle;

    @OneToMany(mappedBy = "movies",cascade = CascadeType.ALL)
    @JsonIgnore
  private  Set<Booking> bookings;

    @ManyToOne
    @JoinColumn(name="cinema_id")
    Cinema cinema;

    @ManyToOne
    @JoinColumn(name="screen_id")
    Screen screen;

   
   

    

}
