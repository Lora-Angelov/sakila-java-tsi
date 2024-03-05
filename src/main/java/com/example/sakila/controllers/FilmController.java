package com.example.sakila.controllers;

import com.example.sakila.entities.Film;
import com.example.sakila.input.FilmInput;
import com.example.sakila.partials.PartialActor;
import com.example.sakila.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class FilmController {

    @Autowired
    FilmRepository filmRepository;

    @GetMapping("/films")
    public List<Film> getAllFilms() { return filmRepository.findAll(); }

    @GetMapping("/films/{id}")
    public Film getFilmById(@PathVariable Short id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No such film."));
    }

    @PostMapping("/films")
    public Film createFilm(@Validated @RequestBody FilmInput data) {
        final var film = new Film();
        film.setTitle(data.getTitle());
        film.setLanguageId(data.getLanguageId());
        film.setRentalDuration(data.getRentalDuration());
        film.setRentalRate(data.getRentalRate());
        film.setLastUpdate(LocalDateTime.now());
        return filmRepository.save(film);
    }

    @PatchMapping("/films/{id}")
    public Film updateFilm(@Validated @PathVariable Short id, @RequestBody FilmInput data) {
        final var film = getFilmById(id);
        if (data.getTitle() != null) {
            film.setTitle(data.getTitle());
        }
        if (data.getLanguageId() != null) {
            film.setLanguageId(data.getLanguageId());
        }
        if (data.getRentalDuration() != null) {
            film.setRentalDuration(data.getRentalDuration());
        }
        if (data.getRentalRate() != null) {
            film.setRentalRate(data.getRentalRate());
        }
        film.setLastUpdate(LocalDateTime.now());
        return filmRepository.save(film);
    }

    @DeleteMapping("/films/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable Short id) {
        filmRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/other/{id}/")
    public List<PartialActor> filmStarsOut (@PathVariable Short id) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Film not found."));
        return film.getActors();
    }*/
}
