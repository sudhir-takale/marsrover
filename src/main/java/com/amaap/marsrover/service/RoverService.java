package com.amaap.marsrover.service;

import com.amaap.marsrover.repository.dto.RoverDto;

public class RoverService {


    public RoverDto create() {
        RoverDto rover = new RoverDto();
        rover.setId(1);
        return rover;
    }
}
