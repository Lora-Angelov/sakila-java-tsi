package com.example.sakila.services;

import com.example.sakila.entities.Actor;
import com.example.sakila.entities.Film;
import com.example.sakila.input.ActorInput;
import com.example.sakila.input.FilmInput;
import com.example.sakila.repositories.ActorRepository;
import com.example.sakila.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmService {

    @Autowired
    private final FilmRepository filmRepository;
    private final ActorRepository actorRepository;

    public FilmService(FilmRepository filmRepository, ActorRepository actorRepository) {
        this.filmRepository = filmRepository;
        this.actorRepository = actorRepository;
    }

    public List<Film> getFilms() {
        return filmRepository.findAll();
    }
    public Film getFilmById(Short id) {
        return filmRepository.findById(id).orElse(null);
    }
    public Film saveFilm(Film film) {
        return filmRepository.save(film);
    }

    public Film updateFilm(Short id, FilmInput data) {
        Film film = filmRepository.findById(id).orElse(null);
        if (data.getTitle() != null) { film.setTitle(data.getTitle()); }
        if (data.getDescription() != null) { film.setDescription(film.getDescription()); }
        if (data.getReleaseYear() != null) { film.setReleaseYear(data.getReleaseYear()); }
        if (data.getLanguageId() != null) { film.setLanguageId(data.getLanguageId()); }
        if (data.getRentalDuration() != null) { film.setRentalDuration(data.getRentalDuration()); }
        if (data.getRentalRate() != null) { film.setRentalRate(data.getRentalRate()); }

        return filmRepository.save(film);
    }

    public void deleteFilm(Short id) {
        filmRepository.deleteById(id);
    }

    public List<Actor> getActorsByFilmId (Short id) {
        Film film = getFilmById(id);
        return new ArrayList<>(film.getActors());
    }
}
