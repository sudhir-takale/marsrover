package com.amaap.marsrover.repository.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlateauDto {

    private int id;
    private final int length;
    private final int breadth;
    private List<DeployedRoverDto> rovers;

    public PlateauDto(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
        rovers = new ArrayList<>();
    }

    public int getBreadth() {
        return breadth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlateauDto that = (PlateauDto) o;
        return length == that.length && breadth == that.breadth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, breadth);
    }

    public void addRover(DeployedRoverDto deployedRoverDto) {
        this.rovers.add(deployedRoverDto);
    }
}
