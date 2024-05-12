package com.amaap.marsrover.service;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.domain.model.Cordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlateauServiceTest {

    @Inject
    PlateauService plateauService;
    @Inject
    RoverService roverService;

    @BeforeEach
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new RoverModule());
        plateauService = injector.getInstance(PlateauService.class);
        roverService = injector.getInstance(RoverService.class);
    }

    @Test
    void shouldBeAbleToCreateANewPlateau() throws InvalidArgumentException {
        // arrange
        int length = 3;
        int breadth = 2;
        PlateauDto expected = new PlateauDto(length, breadth);

        // act
        PlateauDto actual = plateauService.create(length, breadth);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldThrowExceptionIfInvalidLengthIsPassed() {
        // arrange
        int length = -3;
        int breadth = 2;

        // act & assert
        assertThrows(InvalidArgumentException.class, () -> plateauService.create(length, breadth));
    }

    @Test
    void shouldThrowExceptionIfInvalidBreadthIsPassed() {
        // arrange
        int length = 3;
        int breadth = -2;

        // act & assert
        assertThrows(InvalidArgumentException.class, () -> plateauService.create(length, breadth));
    }

    @Test
    void shouldBeAbleToGetPlateauById() throws InvalidArgumentException {
        // arrange
        plateauService.create(8, 4);

        // act
        Optional<PlateauDto> plateauDto1 = plateauService.get(1);

        // assert
        assertEquals(1, plateauDto1.get().getId());


    }

    @Test
    void shouldBeAbleToDeployRoverOnPlateau() throws InvalidArgumentException {
        // arrange
        plateauService.create(8, 4);
        roverService.create();

        // act
        PlateauDto plateauDto = plateauService.deploy(1, 1, new Cordinates(2, 4), Direction.NORTH);

        // assert
        assertEquals(1, plateauDto.getId());
        assertEquals(8, plateauDto.getBreadth());

    }


}