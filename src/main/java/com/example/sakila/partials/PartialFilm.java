/*
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
    private Short filmId;

    @Column(name = "title")
    private String title;

    @Column(name = "language_id")
    private Byte languageId;

    @Column(name = "rental_duration")
    private Integer rentalDuration;

    @Column(name = "rental_rate")
    private BigDecimal rentalRate;

    public PartialFilm() {

    }

    public PartialFilm (Film film) {
            this.title = film.getTitle();
            this.languageId = film.getLanguageId();
            this.rentalDuration = film.getRentalDuration();
            this.rentalRate = film.getRentalRate();
    }

}
*/
