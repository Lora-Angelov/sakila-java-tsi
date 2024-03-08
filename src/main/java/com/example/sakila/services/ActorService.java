package com.example.sakila.services;

import com.example.sakila.entities.Actor;
import com.example.sakila.entities.Film;
import com.example.sakila.input.ActorInput;
import com.example.sakila.repositories.ActorRepository;
import com.example.sakila.repositories.FilmRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ActorService {

    @Autowired
    private final ActorRepository actorRepository;
    private final FilmRepository filmRepository;

    public ActorService(ActorRepository actorRepository, FilmRepository filmRepository) {
        this.actorRepository = actorRepository;
        this.filmRepository = filmRepository;
    }

    public List<Actor> getActors() {
        return actorRepository.findAll();
    }
    public Actor getActorById(Short id) {
        return actorRepository.findById(id).orElse(null);
    }
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    public Actor updateActor(Short id, ActorInput data) {
        Actor actor = actorRepository.findById(id).orElse(null);
        if (data.getFirstName() != null) {
            actor.setFirstName(data.getFirstName());
        }
        if (data.getLastName() != null) {
            actor.setLastName(actor.getLastName());
        }

        return actorRepository.save(actor);
    }

    public void deleteActor(Short id) {
        actorRepository.deleteById(id);
    }

    public List<Film> getFilmsByActorId (Short id) {
        Actor actor = getActorById(id);
        return new ArrayList<>(actor.getFilms());
    }

}
