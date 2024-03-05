/*
package com.example.sakila.services;

import com.example.sakila.entities.Actor;
import com.example.sakila.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    public Optional<Actor> getActorById(Short id) {
        return actorRepository.findById(id);
    }

    public Actor createActor(Actor actor) {
        //add business logic?
        return actorRepository.save(actor);
    }

    public Actor updateActor(Short id, Actor actor) {
        return actorRepository.save(actor);
    }

    public void deleteActor(Short id) {
        actorRepository.deleteById(id);
    }

}
*/
