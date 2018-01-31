package de.networkchallenge.example.cognitosample.lambda.backend.model;

import java.util.List;

public class ResponseObject {

    public String getName() {
        return name;
    }

    public ResponseObject setName(String name) {
        this.name = name;
        return this;
    }

    public enum Status {
        OK, ERROR
    }

    private Status status;
    private String name;

    public Status getStatus() {
        return status;
    }

    public ResponseObject setStatus(final Status status) {
        this.status = status;
        return this;
    }

}