package com.amaap.marsrover.repository.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlateauDto {

    private static List<DeployedRoverDto> rovers = new ArrayList<>();
    private final int length;
    private final int breadth;
    private int id;

    public PlateauDto(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
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


    public List<DeployedRoverDto> getRovers() {
        return rovers;
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

    @Override
    public String toString() {
        return "PlateauDto{" +
                ", id=" + id +
                ", length=" + length +
                "breadth=" + breadth +
                ", rovers=" + rovers +
                '}';
    }

    public int getLength() {
        return this.length;
    }
}
