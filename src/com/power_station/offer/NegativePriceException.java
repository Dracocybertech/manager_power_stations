package com.power_station.offer;

public class NegativePriceException extends RuntimeException {

    public NegativePriceException() {
        super();
    }

    public NegativePriceException(String msg) {
        super(msg);
    }
}
