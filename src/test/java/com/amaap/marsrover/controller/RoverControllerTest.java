package com.amaap.marsrover.controller;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoverControllerTest {

    @Inject
    RoverController roverController;

    @BeforeEach
    public void setup() {
        Injector injector = Guice.createInjector(new RoverModule());
        roverController = injector.getInstance(RoverController.class);
    }

    @Test
    void shouldBeAbleToCreateRover() {
        // arrange
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = roverController.create();

        // assert
        assertEquals(expected, actual);
    }

}
