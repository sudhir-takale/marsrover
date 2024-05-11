package com.amaap.marsrover.repository.impl;

import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.dto.PlateauDto;

public class InMemoryPlateauRepository implements PlateauRepository {
    @Override
    public PlateauDto save(int length, int breadth) {
        return new PlateauDto(length, breadth);
    }
}
