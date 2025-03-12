package test.com.power_station.offer;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;

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
}
