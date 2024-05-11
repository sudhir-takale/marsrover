package com.amaap.marsrover.service;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlateauServiceTest {

    @Inject
    PlateauService plateauService;

    @BeforeEach
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new RoverModule());
        plateauService = injector.getInstance(PlateauService.class);
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


}