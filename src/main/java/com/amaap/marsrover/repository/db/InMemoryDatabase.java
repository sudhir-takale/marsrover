package com.amaap.marsrover.repository.db;

import com.amaap.marsrover.repository.dto.RoverDto;

public interface InMemoryDatabase {
    RoverDto save(RoverDto rover);
}
