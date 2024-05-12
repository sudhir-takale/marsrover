package com.amaap.marsrover.controller;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.domain.model.Cordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        roverController.create();
        plateauController.create(4, 4);
        plateauController.deploy(1, 1, new Cordinates(4, 0), Direction.NORTH);

        // act
        DeployedRoverDto roverDto = instructionController.process(instruction);

        // assert



    }


}
