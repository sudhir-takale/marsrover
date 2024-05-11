package com.amaap.marsrover.repository;

import com.amaap.marsrover.repository.dto.RoverDto;

import java.util.Optional;

public interface RoverRepository {
    RoverDto create();

    Optional<RoverDto> getRoverById(int i);
}
