package test.com.power_station.park;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.power_station.offer.ElectricityBlock;
import com.power_station.park.Park;

public class ParkTest {

    private Park emptyPark;
    private Park park;
    private ArrayList<ElectricityBlock> listElectricityBlocks;
    private ElectricityBlock electricityBlock;

    @Before
    public void beforeTest() {
        System.out.println("Park test starting");
        emptyPark = new Park("Primaire", "Empty Park");
        int energy = 10;
        int price = 20;
        int hours = 3;
        electricityBlock = new ElectricityBlock(energy, price, hours);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        park = new Park("Primaire", "Park 1", listElectricityBlocks);
    }

    @Test
    public void getParksTest() {
        ArrayList<Park> listparks = new ArrayList<>();
        listparks.addAll(Park.getParks());
        Assert.assertTrue(listparks.contains(park));
        Assert.assertTrue(listparks.contains(emptyPark));
        Park newPark = new Park("Primaire", "New Park");
        listparks.addAll(Park.getParks());
        Assert.assertTrue(listparks.contains(newPark));
    }

    @Test
    public void getElectricityBlocks() {
        // Case of a park with no electricity blocks
        ArrayList<ElectricityBlock> emptyList = new ArrayList<>();
        Assert.assertEquals(emptyList, emptyPark.getElectricityBlocks());

        // Case of a park initialized with a list
        Assert.assertEquals(listElectricityBlocks, park.getElectricityBlocks());
    }

    @Test
    public void supplyElectricityBlockTest() {
        // Same block
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlock));

        int energy = electricityBlock.getEnergy();
        int price = electricityBlock.getPrice();
        int hours = electricityBlock.getHours();
        ElectricityBlock electricityBlockSupplied = new ElectricityBlock(energy, price, hours);

        // Different blocks with the same settings
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlockSupplied));
        Assert.assertTrue(electricityBlockSupplied.supplyElectricityBlock(electricityBlock));

        ElectricityBlock electricityBlockNotSupplied = new ElectricityBlock(energy + 10, price, hours);
        // Blocks that can't supply each other because of energy difference
        Assert.assertFalse(electricityBlock.supplyElectricityBlock(electricityBlockNotSupplied));
        Assert.assertFalse(electricityBlockNotSupplied.supplyElectricityBlock(electricityBlock));

        ElectricityBlock electricityBlockSuppliedLessHours = new ElectricityBlock(energy, price, 1);
        // Blocks with different hours so one can supply the other but not the opposite
        Assert.assertFalse(electricityBlockSuppliedLessHours.supplyElectricityBlock(electricityBlock));
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlockSuppliedLessHours));
    }
}
