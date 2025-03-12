package com.power_station.park;

public class TooManyHoursParkException extends RuntimeException {
    public TooManyHoursParkException() {
        super();
    }

    public TooManyHoursParkException(String msg) {
        super(msg);
    }
}
