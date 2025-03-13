package test.com.power_station.offer;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;
import com.power_station.offer.TooManyHoursException;

public class ElectricityOfferTest {
    private ElectricityOffer electricityOfferEmpty;
    private ElectricityOffer electricityOffer;
    ArrayList<ElectricityBlock> listElectricityBlocks;

    @Before
    public void beforeTest() {
        System.out.println("ElectricityOffer test start");
        electricityOfferEmpty = new ElectricityOffer();
        int energy = 10;
        int price = 20;
        int hours = 3;
        ElectricityBlock electricityBlock = new ElectricityBlock(energy, price, hours);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        electricityOffer = new ElectricityOffer(listElectricityBlocks);
    }

    @Test
    public void getElectricityBlocksTest() {
        ArrayList<ElectricityBlock> expectedEmptyList = new ArrayList<>();
        ArrayList<ElectricityBlock> expectedInitList = new ArrayList<>(listElectricityBlocks);
        Assert.assertEquals(expectedEmptyList, electricityOfferEmpty.getElectricityBlocks());
        Assert.assertEquals(expectedInitList, electricityOffer.getElectricityBlocks());
    }

    @Test
    public void addBlockTest() {
        ArrayList<ElectricityBlock> expectedListElectricityBlocks = new ArrayList<>(
                electricityOffer.getElectricityBlocks());
        ElectricityBlock addedElectricityBlock = new ElectricityBlock(1, 1, 1);
        expectedListElectricityBlocks.add(addedElectricityBlock);
        electricityOffer.addBlock(addedElectricityBlock);
        Assert.assertEquals(expectedListElectricityBlocks, electricityOffer.getElectricityBlocks());

    }

    @Test(expected = TooManyHoursException.class)
    public void addBlockTooManyHoursExceptionTest() {
        // Check if the list is not empty so there is at least one electricity block
        Assert.assertFalse(electricityOffer.getElectricityBlocks().isEmpty());
        // Adding a block with 24 hours will trigger the exception since we can't add
        // block with more than 24 hours in total
        ElectricityBlock unvalidElectricityBlock = new ElectricityBlock(1, 1, 24);
        electricityOffer.addBlock(unvalidElectricityBlock);
    }
}
