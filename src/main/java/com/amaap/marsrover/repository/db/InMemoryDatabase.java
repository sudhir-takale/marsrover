package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;

import java.util.Optional;

public interface InMemoryDatabase {
    RoverDto save(RoverDto rover);

    Optional<RoverDto> get(int id);

    PlateauDto insert(PlateauDto plauDto);
}
