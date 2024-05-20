package com.amaap.marsrover;

import com.amaap.marsrover.controller.PlateauController;
import com.amaap.marsrover.controller.RoverController;
import com.amaap.marsrover.controller.dto.Response;
import com.amaap.marsrover.domain.model.Coordinates;
import com.amaap.marsrover.domain.model.Direction;
import com.amaap.marsrover.service.exception.PlateauNotFoundException;
import com.amaap.marsrover.service.exception.RoverNotFoundException;
import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) throws RoverNotFoundException, PlateauNotFoundException {
        Injector injector = Guice.createInjector(new RoverModule());
        RoverController roverController = injector.getInstance(RoverController.class);
        PlateauController plateauController = injector.getInstance(PlateauController.class);
        Response response1 = plateauController.create(2, 3);
        System.out.println(response1);
        Response response = roverController.create();
        System.out.println(response);
        System.out.println(plateauController.get(1));
        System.out.println(plateauController.deploy(1, 1, new Coordinates(2, 2), Direction.N));
        System.out.println(plateauController.get(1));

    }


}
