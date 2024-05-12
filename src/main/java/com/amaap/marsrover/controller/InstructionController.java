package com.amaap.marsrover.controller;

import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.service.InstructionService;
import com.google.inject.Inject;

public class InstructionController {

    private final InstructionService instructionService;

    @Inject
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    public DeployedRoverDto process(String instruction) {
        return instructionService.process(1, instruction);
    }
}
