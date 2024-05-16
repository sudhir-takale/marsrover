package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.dto.RoverDto;
import com.amaap.marsrover.service.PlateauService;
import com.amaap.marsrover.service.exception.InvalidArgumentException;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
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

    public Response get(int id) {
        if (plateauService.get(id).isPresent()) {
            return new Response(HttpStatus.OK, "success");
        } else return new Response(HttpStatus.BAD_REQUEST, "failed");

    }

    public Response deploy(int plateauId, int roverId, Coordinates coordinates, Direction direction) throws RoverNotFoundException, PlateauNotFoundException {

        if (plateauService.deploy(plateauId, roverId, coordinates, direction) != null)
            return new Response(HttpStatus.OK, "success");
        else return new Response(HttpStatus.BAD_REQUEST, "failed");

    }

}
