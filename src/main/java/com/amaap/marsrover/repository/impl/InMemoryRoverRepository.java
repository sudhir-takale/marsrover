package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.google.inject.Inject;

import java.util.Optional;

public class InMemoryRoverRepository implements RoverRepository {

    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryRoverRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public RoverDto create() {
        RoverDto rover = new RoverDto();
        return inMemoryDatabase.save(rover);
    }

    @Override
    public Optional<RoverDto> getRoverById(int id) {
        return inMemoryDatabase.get(id);
    }
}
