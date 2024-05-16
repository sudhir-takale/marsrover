package com.amaap.marsrover.controller;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InstructionControllerTest {


    @Inject
    InstructionController instructionController;
    @Inject
    RoverController roverController;
    @Inject
    PlateauController plateauController;

    @BeforeEach
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new RoverModule());
        instructionController = injector.getInstance(InstructionController.class);
        roverController = injector.getInstance(RoverController.class);
        plateauController = injector.getInstance(PlateauController.class);
    }

    @Test
    void shouldBeAbleToMoveRover() throws RoverNotFoundException, PlateauNotFoundException {
        // arrange
        String instruction = "LM";
        int roverId = 1;
        roverController.create();
        plateauController.create(4, 4);
        plateauController.deploy(1, 1, new Coordinates(4, 0), Direction.N);
        Response expected = new Response(HttpStatus.OK, "success");

        // act
        Response actual = instructionController.process(roverId, instruction);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadRequestIfInvalidRoverIdIsPassed() throws RoverNotFoundException, PlateauNotFoundException {
        // arrange
        String instruction = "LM";
        roverController.create();
        plateauController.create(4, 4);
        plateauController.deploy(1, 1, new Coordinates(4, 0), Direction.N);
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response actual = instructionController.process(3, instruction);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnBadRequestIfInstructionIsEmpty() throws RoverNotFoundException, PlateauNotFoundException {
        // arrange
        String instruction = "";
        roverController.create();
        plateauController.create(4, 4);
        plateauController.deploy(1, 1, new Coordinates(4, 0), Direction.N);
        Response expected = new Response(HttpStatus.BAD_REQUEST, "failed");

        // act
        Response actual = instructionController.process(1, instruction);

        // assert
        assertEquals(expected, actual);
    }

}
