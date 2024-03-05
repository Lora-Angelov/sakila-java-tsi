package com.example.sakila.controllers;

import java.util.List;
import com.example.sakila.entities.Actor;
import com.example.sakila.input.ActorInput;
import com.example.sakila.partials.PartialFilm;
import com.example.sakila.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ActorController {
    @Autowired
    ActorRepository actorRepository;

    @GetMapping("/actors")
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @GetMapping("/actors/{id}")
    public Actor getActorById(@PathVariable Short id) {
        return actorRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "No such actor."));
    }

    @PostMapping("/actors")
    public Actor createActor(@Validated @RequestBody ActorInput data) {
        final var actor = new Actor();
        actor.setFirstName(data.getFirstName());
        actor.setLastName(data.getLastName());
        //actor.setFilmId(data.getFilmId());
        return actorRepository.save(actor);
    }

    @PatchMapping("/actors/{id}")
    public Actor updateActor(@Validated @PathVariable Short id, @RequestBody ActorInput data) {
        final var actor = getActorById(id);
        if (data.getFirstName() != null) {
            actor.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            actor.setLastName(data.getLastName());
        }
        return actorRepository.save(actor);
    }

    @DeleteMapping("/actors/{id}")
    public ResponseEntity<Actor> deleteActor(@PathVariable Short id) {
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
