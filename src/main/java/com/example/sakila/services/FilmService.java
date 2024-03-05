/*
package com.example.sakila.services;

import com.example.sakila.entities.Film;
import com.example.sakila.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepository;

    public List<Film> findAll() {
        return filmRepository.findAll();
    }

    public Optional<Film> findById(Short id) {
        return filmRepository.findById(id);
    }

    public Film save(Film film) {
        return filmRepository.save(film);
    }

    public Film update(Film film) {
        return filmRepository.save(film);
    }

    public void deleteById(Short id) {
        filmRepository.deleteById(id);
    }
}
*/
