package com.example.sakila.controllers;

import java.util.List;
import com.example.sakila.entities.Actor;
import com.example.sakila.entities.Film;
import com.example.sakila.input.ActorInput;
import com.example.sakila.partials.PartialActor;
import com.example.sakila.partials.PartialFilm;
import com.example.sakila.repositories.ActorRepository;
import com.example.sakila.repositories.FilmRepository;
import com.example.sakila.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    FilmRepository filmRepository;

    private final ActorService actorService;

    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return actorService.getActors();
    }

    @GetMapping("/actors/{id}")
    public Actor getActorById(@PathVariable Short id) {
        return actorService.getActorById(id);
    }

    @PostMapping("/actors")
    public Actor createActor(@Validated @RequestBody ActorInput data) {
        final var actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());

        if (data.getFilmId() != null && !data.getFilmId().isEmpty()) {
            List<Film> films = filmRepository.findAllById(data.getFilmId());
            actor.setFilms(films);
        }

        return actorService.saveActor(actor);
    }

    @PatchMapping("/actors/{id}")
    public Actor updateActor(@Validated @PathVariable Short id, @RequestBody ActorInput data) {
        final var actor = getActorById(id);
        if (data.getFirstName() != null) { actor.setFirstName(data.getFirstName()); }
        if (data.getLastName() != null) { actor.setLastName(data.getLastName()); }

        if (data.getFilmId() != null) {
            List<Film> currentFilms = actor.getFilms();
            List<Film> updatedFilms = filmRepository.findAllById(data.getFilmId());

            currentFilms.clear();
            currentFilms.addAll(updatedFilms);
        }

        return actorService.saveActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable Short id) {
        Actor actor = actorService.getActorById(id);

        actor.getFilms().forEach(film -> film.getActors().remove(actor));
        actorService.saveActor(actor);

        actorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /*@GetMapping("/cast/{id}/")
    public List<PartialFilm> filmStarsIn (@PathVariable Short id) {
        Actor actor = actorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Actor not found."));
        return actor.getFilms();
    }*/
}
