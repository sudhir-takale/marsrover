package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.repository.db.impl.FakeInMemoryDatabase;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryDatabaseTest {
    InMemoryDatabase inMemoryDatabase = new FakeInMemoryDatabase();

    @Test
    void shouldBeAbleToSaveRover() {
        // arrange
        RoverDto roverDto = new RoverDto();

        // act
        RoverDto roverDto1 = inMemoryDatabase.save(roverDto);

        // assert
        assertEquals(roverDto, roverDto1);

    }

    @Test
    void shouldBeAbleToGetRoverById() {
        // arrange
        inMemoryDatabase.save(new RoverDto());
        inMemoryDatabase.save(new RoverDto());

        // act
        Optional<RoverDto> roverDto = inMemoryDatabase.get(1);

        // assert
        assertTrue(roverDto.isPresent());
        assertEquals(1, roverDto.get().getId());
    }

    @Test
    void shouldBeAbleToInsertPlateauIntoDatabase() {
        // arrange
        PlateauDto plateauDto = new PlateauDto(2, 2);

        // act
        PlateauDto insert = inMemoryDatabase.insert(plateauDto);

        // assert
        assertEquals(insert, plateauDto);
    }

    @Test
    void shouldBeAbleToGetPlateauDtoById() {
        // arrange
        inMemoryDatabase.insert(new PlateauDto(2, 2));
        inMemoryDatabase.insert(new PlateauDto(2, 2));

        // act
        Optional<PlateauDto> plateauDto = inMemoryDatabase.find(1);

        // assert
        assertEquals(1, plateauDto.get().getId());
    }

    @Test
    void shouldBeAbleToUpdateRoverDto() {
        // arrange
        RoverDto save = inMemoryDatabase.save(new RoverDto());
        save.setDeployed(true);

        // act
        inMemoryDatabase.update(save);

        // assert
        assertTrue(save.isDeployed());


    }

}