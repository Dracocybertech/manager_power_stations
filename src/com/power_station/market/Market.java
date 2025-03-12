package com.power_station.market;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.power_station.offer.ElectricityOffer;

public class Market {

    private String name;
    private ElectricityOffer offer;
    private static Map<String, Market> mapMarkets = new HashMap<>();

    /**
     * Create a Market with a new name.
     * 
     * @param name
     */
    public Market(String name) {
        if (mapMarkets.containsKey(name)) {
            throw new MarketAlreadyExistingException(
                    "The market with this name already exist. Please use another name.");
        }
        this.name = name;
        this.offer = null;
        mapMarkets.put(name, this);
    }

    /**
     * Create a Market with a new name and offers.
     * 
     * @param name
     * @param offers
     */
    public Market(String name, ElectricityOffer offer) {
        if (mapMarkets.containsKey(name)) {
            throw new MarketAlreadyExistingException(
                    "The market with this name already exist. Please use another name.");
        }
        this.name = name;
        this.offer = offer;
        mapMarkets.put(name, this);
    }

    /**
     * Return the electricity offer the market currently has.
     * 
     * @return
     */
    public ElectricityOffer getElectricityOffer() {
        return this.offer;
    }

    /**
     * Return a Collection of the markets.
     * 
     * @return
     */
    public Collection<Market> getMarkets() {
        return Market.mapMarkets.values();
    }

}
