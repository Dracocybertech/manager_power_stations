package test.com.power_station.offer;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.power_station.offer.ElectricityBlock;

public class ElectricityBlockTest {

    private ElectricityBlock electricityBlock;
    private ElectricityBlock electricityBlockSupplied;
    private ElectricityBlock electricityBlockNotSupplied;
    private ElectricityBlock electricityBlockSuppliedLessHours;

    @Before
    public void beforeTest() {
        System.out.println("ElectricityBlock test start");
        int energy = 10;
        int price = 20;
        int hours = 3;
        electricityBlock = new ElectricityBlock(energy, price, hours);
        electricityBlockSupplied = new ElectricityBlock(energy, price, hours);
        electricityBlockNotSupplied = new ElectricityBlock(energy + 10, price + 10, 1);
        electricityBlockSuppliedLessHours = new ElectricityBlock(energy, price, 1);
    }

    @Test
    public void supplyElectricityBlockTest() {
        //Same block
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlock));
        
        //Different blocks with the same settings
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlockSupplied));
        Assert.assertTrue(electricityBlockSupplied.supplyElectricityBlock(electricityBlock));
        
        //Blocks that can't supply each other because of energy difference
        Assert.assertFalse(electricityBlock.supplyElectricityBlock(electricityBlockNotSupplied));
        Assert.assertFalse(electricityBlockNotSupplied.supplyElectricityBlock(electricityBlock));
    
        //Blocks with different hours so one can supply the other but not the opposite
        Assert.assertFalse(electricityBlockSuppliedLessHours.supplyElectricityBlock(electricityBlock));
        Assert.assertTrue(electricityBlock.supplyElectricityBlock(electricityBlockSuppliedLessHours));
    }
}
