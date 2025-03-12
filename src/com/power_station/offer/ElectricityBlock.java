package com.power_station.offer;

public class ElectricityBlock {

    private int energy;
    private int hours;
    private int price;
    private int id;
    private static int idCounter = 0;

    /**
     * Create a electricity block with its period of activity between 1 and 24
     * hours, the energy it
     * produces and its price.
     * 
     * @param energy
     * @param price
     * @param hours
     */
    public ElectricityBlock(int energy, int price, int hours) {
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
        this.id = idCounter + 1;
        idCounter += 1;
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
}
