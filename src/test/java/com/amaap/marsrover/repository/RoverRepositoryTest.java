package com.amaap.marsrover.repository;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.amaap.marsrover.repository.impl.InMemoryRoverRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RoverRepositoryTest {

    @Inject
    RoverRepository roverRepository;

    @BeforeEach
    public void setup() {
        Injector injector = Guice.createInjector(new RoverModule());
        roverRepository = injector.getInstance(InMemoryRoverRepository.class);
    }

    @Test
    void shouldBeAbleToCreateANewRover() {
        // arrange
        RoverDto rover = new RoverDto();
        rover.setId(1);

        // act
        RoverDto actual = roverRepository.create();

        // assert
        assertEquals(rover, actual);


    }


}