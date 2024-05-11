package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.google.inject.Inject;

public class PlateauController {


    private final PlateauService plateauService;

    @Inject
    public PlateauController(PlateauService plateauService) {
        this.plateauService = plateauService;
    }

    public Response create(int length, int breadth) {

        try {
            plateauService.create(length, breadth);
            return new Response(HttpStatus.OK, "success");
        } catch (InvalidArgumentException e) {
            return new Response(HttpStatus.BAD_REQUEST, "failed");
        }
    }
}
