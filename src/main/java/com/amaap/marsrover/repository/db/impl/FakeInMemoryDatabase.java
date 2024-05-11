package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.RoverDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {

    List<RoverDto> rovers = new ArrayList<>();
    private int roverCounter = 0;

    @Override
    public RoverDto save(RoverDto rover) {
        rover.setId(++roverCounter);
        rovers.add(rover);
        return rover;
    }

    @Override
    public Optional<RoverDto> get(int id) {
        RoverDto rover = new RoverDto();
        rover.setId(1);
        return Optional.of(rover);
    }

}
