package test.com.power_station.park;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.power_station.offer.ElectricityBlock;
import com.power_station.park.Park;
import com.power_station.park.ParkAlreadyExistingException;

public class ParkTest {

    private Park emptyPark;
    private Park park;
    private ArrayList<ElectricityBlock> listElectricityBlocks;
    private ElectricityBlock electricityBlock;

    @Before
    public void beforeTest() {
        System.out.println("Park test starting");
        String type = "Solaire";
        emptyPark = new Park(type, "Empty Park");
        int energy = 10;
        int price = 20;
        int hours = 3;
        electricityBlock = new ElectricityBlock(energy, price, hours);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        park = new Park(type, "Park 1", listElectricityBlocks);
    }

    @After
    public void afterTest() {
        Park.clearParks();
    }

    @Test(expected = ParkAlreadyExistingException.class)
    public void parkAlreadyExistingExceptionTest() {
        new Park(park.getType(), park.getName(), park.getElectricityBlocks());
    }

    @Test
    public void getParksTest() {
        ArrayList<Park> listparks = new ArrayList<>();
        listparks.addAll(Park.getParks());
        Assert.assertTrue(listparks.contains(park));
        Assert.assertTrue(listparks.contains(emptyPark));
        Park newPark = new Park("Eolien", "New Park");
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

    @Test
    public void getElectricityBlocksParksTest() {
        ElectricityBlock electricityBlock1 = new ElectricityBlock(20, 10, 1);
        ElectricityBlock electricityBlock2 = new ElectricityBlock(30, 10, 1);
        ElectricityBlock electricityBlock3 = new ElectricityBlock(30, 20, 5);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock1);
        listElectricityBlocks.add(electricityBlock2);
        listElectricityBlocks.add(electricityBlock3);
        new Park("Eolien", "Park Electricity Blocks Parks Test", listElectricityBlocks);
        Map<Integer, List<ElectricityBlock>> electricityBlocksParks = Park.getElectricityBlocksParks();
        
        //Check if the map now has the energy value as key
        Assert.assertTrue(electricityBlocksParks.containsKey(20));
        Assert.assertTrue(electricityBlocksParks.containsKey(30));

        //Check if the array for a specific energy has the electricity block
        ArrayList<ElectricityBlock> energy20List = new ArrayList<>(electricityBlocksParks.get(20));
        Assert.assertTrue(energy20List.contains(electricityBlock1));
        Assert.assertFalse(energy20List.contains(electricityBlock2));
        Assert.assertFalse(energy20List.contains(electricityBlock3));

        ArrayList<ElectricityBlock> energy30List = new ArrayList<>(electricityBlocksParks.get(30));
        Assert.assertTrue(energy30List.contains(electricityBlock2));
        Assert.assertTrue(energy30List.contains(electricityBlock3));
        Assert.assertFalse(energy30List.contains(electricityBlock1));
    }
}
