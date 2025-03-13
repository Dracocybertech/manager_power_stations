package com.power_station.offer;

import com.power_station.park.Park;

public class ElectricityBlock {

    private int energy;
    private int hours;
    private int price;
    private int id;
    private Park park;
    private static int idCounter = 0;

    /**
     * Create a electricity block with its period of activity between 1 and 24
     * hours, the energy it produces, its price and the park it belongs.
     * 
     * @param energy
     * @param price
     * @param hours
     * @param park
     */
    public ElectricityBlock(int energy, int price, int hours, Park park) {
        if (energy < 0) {
            throw new NegativeEnergyException("Energy can't be negative.");
        }
        if (price < 0) {
            throw new NegativePriceException("Price can't be negative.");
        }
        if (hours < 0 || hours > 24) {
            throw new OutOfRangeHoursException("Hours can't be under 0 and over 24.");
        }
        this.energy = energy;
        this.price = price;
        this.hours = hours;
        this.park = park;
        this.id = idCounter + 1;
        idCounter += 1;
    }

    /**
     * Create a electricity block with its period of activity between 1 and 24
     * hours, the energy it produces and its price.
     * 
     * @param energy
     * @param price
     * @param hours
     */
    public ElectricityBlock(int energy, int price, int hours) {
        this(energy, price, hours, null);
    }

    public int getEnergy() {
        return this.energy;
    }

    public int getHours() {
        return this.hours;
    }

    public int getPrice() {
        return this.price;
    }

    public int getId() {
        return this.id;
    }

    public Park getPark() {
        return this.park;
    }

    public void setEnergy(int energy) {
        if (energy < 0) {
            throw new NegativeEnergyException("Energy can't be negative.");
        }
        this.energy = energy;
    }

    public void setPrice(int price) {
        if (price < 0) {
            throw new NegativePriceException("Price can't be negative.");
        }
        this.price = price;
    }

    /**
     * Set the park to which the electricity block belongs.
     * 
     * @param park
     */
    public void setPark(Park park) {
        this.park = park;
    }

    /**
     * Return true if the current block can provide for another block given that
     * price can't be lower, hours can't be higher and the energy must be the same.
     * 
     * @param blockToSupply
     * @return True if the current block can supply the provided block
     */
    public boolean supplyElectricityBlock(ElectricityBlock blockToSupply) {
        return blockToSupply.getEnergy() == this.energy
                && blockToSupply.getHours() <= this.hours
                && blockToSupply.getPrice() >= this.price;
    }
}
