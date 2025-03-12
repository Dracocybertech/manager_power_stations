package com.power_station.offer;

public class OutOfRangeHoursException extends RuntimeException {

    public OutOfRangeHoursException() {
        super();
    }

    public OutOfRangeHoursException(String msg) {
        super(msg);
    }
}
