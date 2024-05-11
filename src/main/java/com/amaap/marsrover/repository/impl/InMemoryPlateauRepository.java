package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.db.InMemoryDatabase;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.google.inject.Inject;

public class InMemoryPlateauRepository implements PlateauRepository {
    private final InMemoryDatabase inMemoryDatabase;

    @Inject
    public InMemoryPlateauRepository(InMemoryDatabase inMemoryDatabase) {
        this.inMemoryDatabase = inMemoryDatabase;
    }

    @Override
    public PlateauDto save(int length, int breadth) {
        PlateauDto plauDto = new PlateauDto(length, breadth);
        return inMemoryDatabase.insert(plauDto);
    }
}
