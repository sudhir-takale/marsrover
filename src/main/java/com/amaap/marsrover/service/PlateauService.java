package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.PlateauRepository;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Inject;

import java.util.Optional;

public class PlateauService {
    private final PlateauRepository plateauRepository;
    private final RoverService roverService;

    @Inject
    public PlateauService(PlateauRepository plateauRepository, RoverService roverService) {
        this.plateauRepository = plateauRepository;
        this.roverService = roverService;
    }

    public PlateauDto create(int length, int breadth) throws InvalidArgumentException {
        if (length <= 0 || breadth <= 0) throw new InvalidArgumentException("invalid parameters passed");
        return plateauRepository.save(length, breadth);
    }

    public Optional<PlateauDto> get(int id) {
        return plateauRepository.get(id);
    }

    public PlateauDto deploy(int plateauId, int roverId, Coordinates coordinates, Direction direction) throws PlateauNotFoundException, RoverNotFoundException {
        Optional<RoverDto> rover = roverService.get(roverId);
        if (rover.isEmpty()) throw new RoverNotFoundException("Rover not found for id " + roverId);

        Optional<PlateauDto> plateau = get(plateauId);
        if (plateau.isEmpty()) throw new PlateauNotFoundException("Plateau not found for id " + plateauId);

        plateau.get().addRover(new DeployedRoverDto(rover.get().getId(), coordinates, direction));
        roverService.markDeployed(rover.get());
        return plateau.get();
    }
}
