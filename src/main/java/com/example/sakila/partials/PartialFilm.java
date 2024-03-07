package com.example.sakila.partials;

import com.example.sakila.entities.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;

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

    @Column(name = "description")
    String description;

    @Column(name = "release_year")
    Year releaseYear;

    @Column(name = "language_id")
    Byte languageId;

    public PartialFilm() {

    }

    public PartialFilm (Film film) {
        this.filmId = film.getId();
        this.title = film.getTitle();
        this.languageId = film.getLanguageId();
        this.description = film.getDescription();
        this.releaseYear = film.getReleaseYear();
    }
}
