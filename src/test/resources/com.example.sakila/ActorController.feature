Feature: Actor

  Scenario: Actor is fetched by id
    Given The actor with id 1 exists
    When GET request is made for an actor with ID 1
    Then An actor is returned