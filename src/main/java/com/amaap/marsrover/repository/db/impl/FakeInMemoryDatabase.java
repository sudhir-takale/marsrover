package com.amaap.marsrover.repository.db.impl;

import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.empty;

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

        return rovers.stream()
                .filter(plateauDto1 -> plateauDto1.getId() == id)
                .findFirst();
    }

    @Override
    public PlateauDto insert(PlateauDto plateauDto) {
        plateauDto.setId(++plateauCounter);
        plateauDtos.add(plateauDto);
        return plateauDto;
    }

    @Override
    public Optional<PlateauDto> find(int id) {
        return plateauDtos.stream().filter(plateauDto1 -> plateauDto1.getId() == id).findFirst();
    }

    @Override
    public void update(RoverDto roverDto) {
        for (RoverDto rover : rovers) {
            if (rover.getId() == roverDto.getId()) rover.setDeployed(true);
        }
    }

}
