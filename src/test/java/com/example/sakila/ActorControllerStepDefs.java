package com.example.sakila;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.example.sakila.controllers.ActorController;
import com.example.sakila.entities.Actor;
import com.example.sakila.services.ActorService;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class ActorControllerStepDefs {
    private ActorService actorService;

    private final Short Id = 1;

    private final Actor expectedActor = new Actor(Id, "John", "Doe", new ArrayList<>());

    private Actor actualActor;

    @Before
    public void setUp() {
        actorService = mock(ActorService.class);
    }

    @Given("The actor with id {short} exists")
    public void givenActorOneExists(Short id) {
        doReturn(expectedActor).when(actorService).getActorById(id);
    }

    @When("GET request is made for an actor with ID {short}")
    public void whenRequestWithId(Short id) {
        final ActorController actorController = new ActorController(actorService);
        try {
            actualActor = actorController.getActorById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Then("An actor is returned")
    public void thenActorIsReturned() {
        assertNotNull(actualActor);
        //assertEquals();
    }

}
