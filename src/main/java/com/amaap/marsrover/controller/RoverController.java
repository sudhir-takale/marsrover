package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.service.RoverService;
import com.google.inject.Inject;

public class RoverController {
    private final RoverService roverService;

    @Inject
    public RoverController(RoverService roverService) {
        this.roverService = roverService;
    }

    public Response create() {
        roverService.create();
        return new Response(HttpStatus.OK, "success");
    }
}
