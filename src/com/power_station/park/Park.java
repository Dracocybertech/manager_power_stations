package com.power_station.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.power_station.offer.ElectricityBlock;

public class Park {

    private String type;
    private String name;
    private List<ElectricityBlock> electricityBlocks;
    private static Map<String, Park> mapParks;

    /**
     * Create Park with empty production blocks.
     * 
     * @param type
     * @param name
     */
    public Park(String type, String name) {
        this(type, name, null);
    }

    /**
     * Create a Park with supplied production blocks.
     * 
     * @param type
     * @param name
     */
    public Park(String type, String name, List<ElectricityBlock> electricityBlocks) {
        if (mapParks.containsKey(name)) {
            throw new ParkAlreadyExistingException("Park with this name already exists.");
        }
        this.name = name;
        this.type = type;
        this.electricityBlocks = new ArrayList<>(electricityBlocks);
        mapParks.put(name, this);
    }

    /**
     * Return the type of the park.
     * 
     * @return The type of the park
     */
    public String getType() {
        return this.type;
    }
}
