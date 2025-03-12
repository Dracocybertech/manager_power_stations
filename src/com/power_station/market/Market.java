package com.power_station.market;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {

    private String name;
    private List<ElectricityOffer> offers;
    private static Map<String, Market> listmarkets = new HashMap<>();

    /**
     * Create a Market with a new name.
     * @param name
     */
    public Market(String name) {
        if (listmarkets.containsKey(name)) {
            throw new MarketAlreadyExistingException(
                    "The market with this name already exist. Please use another name.");
        }
        this.name = name;
        this.offers = new ArrayList<>();
        listmarkets.put(name, this);
    }

    /**
     * Create a Market with a new name and offers.
     * @param name
     * @param offers
     */
    public Market(String name, List<ElectricityOffer> offers) {
        if (listmarkets.containsKey(name)) {
            throw new MarketAlreadyExistingException(
                    "The market with this name already exist. Please use another name.");
        }
        this.name = name;
        this.offers = new ArrayList<>(offers);
        listmarkets.put(name, this);
    }
}
