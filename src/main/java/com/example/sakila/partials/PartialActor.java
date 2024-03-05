package com.example.sakila.partials;

import com.example.sakila.entities.Actor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "actor")
@Getter
@Setter

public class PartialActor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "actor_id")
    private Short Id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public PartialActor() {

    }

    public PartialActor(Actor actor) {
        this.Id = actor.getId();
        this.firstName = actor.getFirstName();
        this.lastName = actor.getLastName();
    }

}
