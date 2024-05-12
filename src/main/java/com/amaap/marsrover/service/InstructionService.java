package com.amaap.marsrover.service;

import com.amaap.marsrover.domain.service.InstructionProcessor;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.repository.dto.PlateauDto;
import com.amaap.marsrover.service.exception.InvalidInstructionException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Inject;

import java.util.List;
import java.util.Optional;


public class InstructionService {

    private final PlateauService plateauService;

    @Inject
    public InstructionService(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    public DeployedRoverDto process(int roverId, String instruction) throws InvalidInstructionException, RoverNotFoundException {

        if (instruction.isEmpty()) throw new InvalidInstructionException("invalid instruction given");

        Optional<PlateauDto> plateauDto = plateauService.get(1);
        if (!plateauDto.isPresent()) throw new RoverNotFoundException("Plateau not found exception" + roverId);

        List<DeployedRoverDto> deployedRoverDto = plateauDto.get().getRovers();

        Optional<DeployedRoverDto> roverOptional = deployedRoverDto
                .stream()
                .filter(rover -> rover.getId() == roverId)
                .findFirst();

        return InstructionProcessor.process(roverOptional.get(), instruction);
    }
}
