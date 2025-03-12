package com.power_station.market;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.power_station.offer.ElectricityOffer;

public class Market {

    private String name;
    private List<ElectricityOffer> offers;
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
        this.offers = new ArrayList<>();
        mapMarkets.put(name, this);
    }

    /**
     * Create a Market with a new name and offers.
     * 
     * @param name
     * @param offers
     */
    public Market(String name, List<ElectricityOffer> offers) {
        if (mapMarkets.containsKey(name)) {
            throw new MarketAlreadyExistingException(
                    "The market with this name already exist. Please use another name.");
        }
        this.name = name;
        this.offers = new ArrayList<>(offers);
        mapMarkets.put(name, this);
    }

    /**
     * Return the list of electricity offers the market currently has.
     * @return
     */
    public List<ElectricityOffer> getElectricityOffers() {
        return this.offers;
    }

    /**
     * Return a Collection of the markets.
     * @return
     */
    public Collection<Market> getMarkets() {
        return Market.mapMarkets.values();
    }
}
