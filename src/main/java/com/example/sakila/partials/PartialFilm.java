package com.example.sakila.partials;

import com.example.sakila.entities.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "film")
@Getter
@Setter

public class PartialFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "film_id")
    Short filmId;

    @Column(name = "title")
    String title;

    @Column(name = "language_id")
    Byte languageId;

    @Column(name = "rental_duration")
    Integer rentalDuration;

    @Column(name = "rental_rate")
    BigDecimal rentalRate;

    public PartialFilm() {

    }

    public PartialFilm (Film film) {
            this.title = film.getTitle();
            this.languageId = film.getLanguageId();
            this.rentalDuration = film.getRentalDuration();
            this.rentalRate = film.getRentalRate();
    }
}
