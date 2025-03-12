package com.power_station.offer;

public class NegativeEnergyException extends RuntimeException {

    public NegativeEnergyException() {
        super();
    }

    public NegativeEnergyException(String msg) {
        super(msg);
    }
}
