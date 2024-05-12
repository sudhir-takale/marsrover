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

public class PlateauControllerTest {

    @Inject
    PlateauController plateauController;

    @BeforeEach
    public void setup() {
        Injector injector = Guice.createInjector(new RoverModule());
        plateauController = injector.getInstance(PlateauController.class);
    }

    @Test
    void shouldBeAbleToCreatePlateauWithGivenParameters() {
        // arrange
        int length = 3;
        int breadth = 2;
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = plateauController.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadRequestIfPlateauDimensionsAreInvalid() {
        // arrange
        int length = -3;
        int breadth = 2;
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response actual = plateauController.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToGetPlateauById() {
        // arrange
        Response expected = new Response(HttpStatus.OK, "success");
        plateauController.create(8, 4);

        // act
        Response actual = plateauController.get(1);

        // assert
        assertEquals(expected, actual);

    }

}
