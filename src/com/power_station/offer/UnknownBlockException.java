package com.power_station.offer;

public class UnknownBlockException extends RuntimeException {
    public UnknownBlockException() {
        super();
    }

    public UnknownBlockException(String msg) {
        super(msg);
    }
}
