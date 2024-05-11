package com.amaap.marsrover.service;

import com.amaap.marsrover.repository.RoverRepository;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.google.inject.Inject;

import java.util.Optional;

public class RoverService {

    private final RoverRepository roverRepository;

    @Inject
    public RoverService(RoverRepository roverRepository) {
        this.roverRepository = roverRepository;
    }

    public RoverDto create() {
        return roverRepository.create();
    }

    public Optional<RoverDto> get(int id) {
        return roverRepository.getRoverById(id);

    }
}
