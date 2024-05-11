package com.amaap.marsrover.controller;

import com.amaap.marsrover.controller.dto.HttpStatus;
import com.amaap.marsrover.controller.dto.Response;

public class RoverController {
    public Response create() {
        return new Response(HttpStatus.OK, "success");
    }
}
