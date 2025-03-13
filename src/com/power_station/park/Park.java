package com.power_station.park;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.power_station.offer.ElectricityBlock;

public class Park {

    private String type;
    private String name;
    private List<ElectricityBlock> electricityBlocks;
    private static Map<String, Park> mapParks = new HashMap<>();
    private int totalHours = 0;
    private static Map<Integer, List<ElectricityBlock>> electricityBlocksParks = new HashMap<>();

    /**
     * Create Park with empty production blocks.
     * 
     * @param type
     * @param name
     */
    public Park(String type, String name) {
        this(type, name, new ArrayList<>());
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
        for (ElectricityBlock block : electricityBlocks) {
            totalHours += block.getHours();
        }
        if (totalHours > 24) {
            throw new TooManyHoursParkException("Park can't produced over 24 hours of electricity.");
        }
        this.name = name;
        this.type = type;
        this.electricityBlocks = new ArrayList<>(electricityBlocks);

        // Add the block to the right energy list of electricity block
        for (ElectricityBlock block : this.electricityBlocks) {
            // If there isn't any block with the same energy already existing in any offer
            // we create the array for this energy
            if (!electricityBlocksParks.containsKey(block.getEnergy())) {
                ArrayList<ElectricityBlock> listElectricityBlocks = new ArrayList<>();
                listElectricityBlocks.add(block);
                electricityBlocksParks.put(block.getEnergy(), listElectricityBlocks);
            } else {
                electricityBlocksParks.get(block.getEnergy()).add(block);
            }
        }
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

    /**
     * Return the name of the park.
     * 
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Return a collection of all the parks existing.
     * 
     * @return collection of all the parks
     */
    public static Collection<Park> getParks() {
        return Park.mapParks.values();
    }

    /**
     * Return all electricity blocks for this park.
     * 
     * @return all electricity blocks
     */
    public List<ElectricityBlock> getElectricityBlocks() {
        return this.electricityBlocks;
    }

    /**
     * Return all electricity blocks for every park existing, classified by energy.
     * 
     * @return
     */
    public static Map<Integer, List<ElectricityBlock>> getElectricityBlocksParks() {
        return electricityBlocksParks;
    }

    /**
     * Remove all parks created.
     */
    public static void clearParks() {
        Park.mapParks.clear();
    }

    /**
     * Remove all electricity blocks from the general map.
     */
    public static void clearElectricityBlocksParks() {
        electricityBlocksParks.clear();
    }

    /**
     * Return true if at least one block in the park can supply a given block.
     * 
     * @param blockToSupply
     * @return True if the park can provide for a given block
     */
    public boolean supplyElectricityBlock(ElectricityBlock blockToSupply) {
        for (ElectricityBlock electricityBlock : this.electricityBlocks) {
            if (electricityBlock.supplyElectricityBlock(blockToSupply)) {
                return true;
            }
        }
        return false;
    }
}
