package com.movie.bookmovie.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "screen")
public class Screen {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "screen_id")
    int id;

    String screen_type; //front //3D

    @OneToMany(mappedBy = "screen",cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Movies> movies;
}
