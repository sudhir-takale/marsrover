package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FakeInMemoryDatabase implements InMemoryDatabase {

    List<RoverDto> rovers = new ArrayList<>();
    List<PlateauDto> plateauDtos = new ArrayList<>();
    private int roverCounter = 0;
    private int plateauCounter = 0;

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

    @Override
    public PlateauDto insert(PlateauDto plateauDto) {
        plateauDto.setId(++plateauCounter);
        plateauDtos.add(plateauDto);
        return plateauDto;
    }

    @Override
    public Optional<PlateauDto> find(int id) {
        PlateauDto plateauDto = new PlateauDto(8, 4);
        plateauDto.setId(1);
        return Optional.of(plateauDto);
    }

    @Override
    public void update(RoverDto roverDto) {
        for (RoverDto rover : rovers) {
            if (rover.getId() == roverDto.getId()) rover.setDeployed(true);
        }
    }

}
