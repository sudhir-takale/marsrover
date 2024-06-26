package com.amaap.marsrover.service;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RoverServiceTest {

    @Inject
    RoverService roverService;

    @BeforeEach
    void setUp() {
        Injector injector = Guice.createInjector(new RoverModule());
        roverService = injector.getInstance(RoverService.class);
    }

    @Test
    void shouldBeAbleToCreateANewRover() {
        // arrange
        RoverDto rover = new RoverDto();
        rover.setId(1);

        // act
        RoverDto actual = roverService.create();

        // assert
        assertEquals(rover, actual);
    }

    @Test
    void shouldBeAbleToSaveRoverIntoDatabase() {
        // arrange
        RoverDto rover = new RoverDto();
        rover.setId(1);

        // act
        RoverDto actual = roverService.create();

        // assert
        assertEquals(rover, actual);
        assertFalse(rover.isDeployed());
    }

    @Test
    void shouldBeAbleToGetRoverById() {
        // arrange
        RoverDto rover = new RoverDto();
        rover.setId(1);

        // act
        Optional<RoverDto> actual = roverService.get(1);

        // assert
        assertEquals(1, actual.get().getId());
    }

    @Test
    void shouldBeAbleToUpdateTheStatusOfRoverWhenDeployed() {
        // arrange
        RoverDto rover = new RoverDto();
        rover.setId(1);

        // act
        roverService.markDeployed(rover);

        // assert
        assertTrue(rover.isDeployed());
    }


}