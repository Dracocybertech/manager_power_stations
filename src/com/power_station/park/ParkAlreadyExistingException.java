package com.power_station.park;

public class ParkAlreadyExistingException extends RuntimeException {
    public ParkAlreadyExistingException() {
        super();
    }

    public ParkAlreadyExistingException(String msg) {
        super(msg);
    }
}
