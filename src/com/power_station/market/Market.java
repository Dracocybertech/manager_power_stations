package com.power_station.market;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;
import com.power_station.park.Park;

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

    /**
     * Return the list of the parks which can produced electricity for this market.
     * Return an empty list if there isn't any park or if there isn't any
     * configuration of parks to supply the market.
     * 
     * @return
     */
    public List<Park> getListParkOffer() {
        ArrayList<Park> listParksResult = new ArrayList<>();
        List<Park> listParks = new ArrayList<>(Park.getParks());
        if (this.getElectricityOffer() == null || listParks.isEmpty()) {
            return listParksResult;
        }

        // Get all the electricity blocks we need to supply for this offer
        List<ElectricityBlock> offerBlocks = this.getElectricityOffer().getElectricityBlocks();

        // For each electricity block, we see if there is a park which can supply it
        for (ElectricityBlock block : offerBlocks) {
            ArrayList<Park> listParkBlock = new ArrayList<>();
            for (Park park : listParks) {
                if (park.supplyElectricityBlock(block)) {
                    listParkBlock.add(park);
                }
                // There isn't any park that can provide for one of the electricity block
                if (listParkBlock.isEmpty()) {
                    return new ArrayList<>();
                }
                //Add the parks to the result lists
                listParksResult.addAll(listParkBlock);
            }
        }

        return listParksResult;
    }
}
