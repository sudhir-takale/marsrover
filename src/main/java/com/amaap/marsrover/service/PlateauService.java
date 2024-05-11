package com.amaap.marsrover.service;

import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.google.inject.Inject;

public class PlateauService {
    private final PlateauRepository plateauRepository;

    @Inject
    public PlateauService(PlateauRepository plateauRepository) {
        this.plateauRepository = plateauRepository;
    }

    public PlateauDto create(int length, int breadth) throws InvalidArgumentException {
        if (length <= 0 || breadth <= 0) throw new InvalidArgumentException("invalid parameters passed");
        return plateauRepository.save(length, breadth);
    }
}
