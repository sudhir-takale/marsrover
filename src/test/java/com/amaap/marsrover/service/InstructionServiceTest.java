package com.amaap.marsrover.service;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.amaap.marsrover.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class InstructionServiceTest {

    @Inject
    InstructionService instructionService;

    @Inject
    RoverService roverService;

    @Inject
    PlateauService plateauService;

    @BeforeEach
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new RoverModule());
        instructionService = injector.getInstance(InstructionService.class);
        roverService = injector.getInstance(RoverService.class);
        plateauService = injector.getInstance(PlateauService.class);
    }

    @Test
    void shouldBeAbleToProcessInstruction() throws InvalidArgumentException, RoverNotFoundException, PlateauNotFoundException, InvalidInstructionException {
        // arrange
        String instruction = "LMLMLMLMM";
        int roverId = 1;
        roverService.create();
        plateauService.create(8, 4);
        PlateauDto deploy = plateauService.deploy(1, 1, new Coordinates(1, 2), Direction.N);
        List<DeployedRoverDto> rovers = deploy.getRovers();
        System.out.println("in test");
        for(DeployedRoverDto rover : rovers) System.out.println(rover);

        // act
        DeployedRoverDto deployedRoverDto = instructionService.process(roverId, instruction);

        // assert
        System.out.println(deployedRoverDto);

    }

    @Test
    void shouldThrowExceptionIfInstructionIsEmpty() {
        // arrange
        String instruction = "";
        int roverId = 1;

        // act & assert
        assertThrows(InvalidInstructionException.class, ()->instructionService.process(roverId, instruction));

    }

}