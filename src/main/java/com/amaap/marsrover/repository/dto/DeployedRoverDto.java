package com.amaap.marsrover.repository.dto;

import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;

public class DeployedRoverDto {

    private final int id;
    private Direction direction;
    private Coordinates coordinates;

    public DeployedRoverDto(int id, Coordinates coordinates, Direction direction) {
        this.id = id;
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DeployedRoverDto{" + "coordinates=" + coordinates + ", id=" + id + ", direction=" + direction + '}';
    }
}
