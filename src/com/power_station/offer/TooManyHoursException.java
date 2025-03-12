package com.power_station.offer;

public class TooManyHoursException extends RuntimeException {

    public TooManyHoursException() {
        super();
    }

    public TooManyHoursException(String msg) {
        super(msg);
    }
}
