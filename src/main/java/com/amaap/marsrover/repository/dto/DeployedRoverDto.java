package com.amaap.marsrover.repository.dto;

import com.amaap.marsrover.domain.model.Cordinates;
import com.amaap.marsrover.domain.model.Direction;

public class DeployedRoverDto {

    private final int id;
    private final Cordinates cordinates;
    private final Direction direction;

    public DeployedRoverDto(int id, Cordinates cordinates, Direction direction) {
        this.id = id;
        this.cordinates = cordinates;
        this.direction = direction;
    }

    public Cordinates getCordinates() {
        return cordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public int getId() {
        return id;
    }
}
