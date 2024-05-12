package com.amaap.marsrover.repository;

import com.amaap.marsrover.repository.dto.PlateauDto;

import java.util.Optional;

public interface PlateauRepository {
    PlateauDto save(int length, int breadth);

    Optional<PlateauDto> get(int id);
}
