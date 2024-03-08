package com.example.sakila.entities;

import com.example.sakila.partials.PartialFilm;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "actor")
@Getter
@Setter

public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Short Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToMany
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "actor_id")},
            inverseJoinColumns = {@JoinColumn(name = "film_id")}
    )
    @JsonManagedReference
    private List<Film> films = new ArrayList<>();

    public Actor() {

    }

    public Actor(Short Id, String firstName, String lastName, ArrayList<Film> films) {
        this.firstName = firstName;
        this.lastName = lastName;
        //this.FilmIds = filmIds;
        this.films = films;
        this.Id = Id;
    }

}
