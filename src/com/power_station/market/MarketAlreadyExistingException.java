package com.power_station.market;

public class MarketAlreadyExistingException extends RuntimeException {
    public MarketAlreadyExistingException() {
        super();
    }

    public MarketAlreadyExistingException(String msg) {
        super(msg);
    }
}
