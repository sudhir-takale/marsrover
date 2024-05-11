package com.amaap.marsrover.repository;

import com.amaap.marsrover.RoverModule;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.impl.InMemoryPlateauRepository;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlateauRepositoryTest {

    @Inject
    PlateauRepository plateauRepository;

    @BeforeEach
    public void setUp() throws Exception {
        Injector injector = Guice.createInjector(new RoverModule());
        plateauRepository = injector.getInstance(InMemoryPlateauRepository.class);

    }

    @Test
    void shouldBeAbleToCrateANewPlateau() {
        // arrange
        int length = 4;
        int breadth = 3;
        PlateauDto expected = new PlateauDto(length, breadth);

        // act
        PlateauDto actual = plateauRepository.save(length, breadth);

        // assert
        assertEquals(expected, actual);

    }

}