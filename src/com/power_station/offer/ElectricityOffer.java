package com.power_station.offer;

import java.util.ArrayList;
import java.util.List;

public class ElectricityOffer {

    private List<ElectricityBlock> electricityBlocks;
    private int id;
    private static int idCounter = 0;
    private int totalHours = 0;

    /**
     * Create an empty electricity offer.
     */
    public ElectricityOffer() {
        electricityBlocks = new ArrayList<>();
        this.id = idCounter + 1;
        idCounter += 1;
    }

    /**
     * Create an electricity offer with electricity blocks of production. Blocks of
     * production can't exceed 24 hours.
     * 
     * @param electricityBlocks
     */
    public ElectricityOffer(List<ElectricityBlock> electricityBlocks) {
        for (ElectricityBlock block : electricityBlocks) {
            totalHours += block.getHours();
        }
        if (totalHours > 24) {
            throw new TooManyHoursException("There can't be more than 24 hours with all of the combined hours.");
        }
        this.electricityBlocks = new ArrayList<>(electricityBlocks);

        this.id = idCounter + 1;
        idCounter += 1;
    }

    /**
     * Return the list of electricity blocks.
     * 
     * @return List of all {@link ElectricityBlock}
     */
    public List<ElectricityBlock> getElectricityBlocks() {
        return this.electricityBlocks;
    }

    public int getId() {
        return this.id;
    }

    /**
     * Add a electricity block to the offer, if the offer doesn't exceed 24 hours.
     * 
     * @param electricityBlock
     */
    public void addBlock(ElectricityBlock electricityBlock) {
        if (totalHours + electricityBlock.getHours() > 24) {
            throw new TooManyHoursException("There can't be more than 24 hours with all of the combined hours.");
        }
        this.electricityBlocks.add(electricityBlock);
    }

    /**
     * Remove an electricity block from the offer
     * 
     * @param electricityBlock
     * @throws UnknownBlockException
     */
    public void removeBlock(ElectricityBlock electricityBlock) throws UnknownBlockException {
        if (this.electricityBlocks.remove(electricityBlock)) {
            totalHours -= electricityBlock.getHours();
        } else {
            throw new UnknownBlockException("The block can't be removed because it doesn't exist.");
        }
    }

    /**
     * Remove an electricity block from the offer
     * 
     * @param indexBlock
     */
    public void removeBlock(int indexBlock) {
        ElectricityBlock removedBlock = this.electricityBlocks.remove(indexBlock);
        totalHours -= removedBlock.getHours();
    }

    /**
     * Return the number of electricity blocks the offer has.
     * 
     * @return the number of electricity blocks
     */
    public int getNumberBlocks() {
        return this.electricityBlocks.size();
    }
}
