package com.amaap.marsrover.controller.dto;

import java.util.Objects;

public class Response {
    private final String response;
    private final HttpStatus httpStatus;

    public Response(HttpStatus httpStatus, String response) {
        this.httpStatus = httpStatus;
        this.response = response;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Response response1 = (Response) o;
        return Objects.equals(response, response1.response) && httpStatus == response1.httpStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(response, httpStatus);
    }
}
