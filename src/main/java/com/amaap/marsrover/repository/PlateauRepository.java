package com.amaap.marsrover.repository;

import com.amaap.marsrover.repository.dto.PlateauDto;

public interface PlateauRepository {
    PlateauDto save(int length, int breadth);
}
