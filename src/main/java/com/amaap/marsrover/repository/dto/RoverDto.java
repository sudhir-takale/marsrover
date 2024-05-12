package com.amaap.marsrover.repository.dto;

import java.util.Objects;

public class RoverDto {

    private int id;
    private boolean isDeployed;

    public RoverDto() {
        this.isDeployed = false;
    }

    public boolean isDeployed() {
        return isDeployed;
    }

    public void setDeployed(boolean deployed) {
        isDeployed = deployed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoverDto roverDto = (RoverDto) o;
        return id == roverDto.id && isDeployed == roverDto.isDeployed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isDeployed);
    }

    @Override
    public String toString() {
        return "RoverDto{" +
                "id=" + id +
                ", isDeployed=" + isDeployed +
                '}';
    }
}
