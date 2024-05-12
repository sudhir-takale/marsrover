package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;
import com.amaap.marsrover.service.InstructionService;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Inject;

public class InstructionController {

    private final InstructionService instructionService;

    @Inject
    public InstructionController(InstructionService instructionService) {
        this.instructionService = instructionService;
    }

    public Response process(int roverId, String instruction) throws RoverNotFoundException {
        try {
            DeployedRoverDto process = instructionService.process(roverId, instruction);
            return new Response(HttpStatus.OK, process.toString());
        } catch (Exception e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }
    }
}
