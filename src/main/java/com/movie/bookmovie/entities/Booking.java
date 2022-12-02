package com.movie.bookmovie.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.core.sym.Name;
import com.mysql.cj.x.protobuf.MysqlxCrud.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;


 @ManyToOne
 @JoinColumn(name="user_id")
 User user;

 @ManyToOne
 @JoinColumn(name="movie_id")
 Movies movies;




}
