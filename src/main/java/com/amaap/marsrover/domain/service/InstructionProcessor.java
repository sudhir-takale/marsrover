package com.amaap.marsrover.domain.service;

import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.repository.dto.DeployedRoverDto;

public class InstructionProcessor {

    public static DeployedRoverDto process(DeployedRoverDto deployedRoverDto, String instruction) {

        int x = deployedRoverDto.getCoordinates().getX();
        int y = deployedRoverDto.getCoordinates().getY();
        char direction = 'N';

        for (int i = 0; i < instruction.length(); i++) {
            char move = instruction.charAt(i);

            if (move == 'L') {
                if (direction == 'N') {
                    direction = 'W';
                } else if (direction == 'W') {
                    direction = 'S';
                } else if (direction == 'S') {
                    direction = 'E';
                } else if (direction == 'E') {
                    direction = 'N';
                }
            } else if (move == 'R') {
                if (direction == 'N') {
                    direction = 'E';
                } else if (direction == 'E') {
                    direction = 'S';
                } else if (direction == 'S') {
                    direction = 'W';
                } else if (direction == 'W') {
                    direction = 'N';
                }
            } else if (move == 'M') {
                if (direction == 'N') {
                    y++;
                } else if (direction == 'E') {
                    x++;
                } else if (direction == 'S') {
                    y--;
                } else if (direction == 'W') {
                    x--;
                }
            }
        }

        deployedRoverDto.getCoordinates().setX(x);
        deployedRoverDto.getCoordinates().setY(y);
        deployedRoverDto.setDirection(Direction.valueOf(String.valueOf(direction)));

        return deployedRoverDto;
    }
}
