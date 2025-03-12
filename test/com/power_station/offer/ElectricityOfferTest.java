package test.com.power_station.offer;

import java.util.ArrayList;

import org.junit.Before;

import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;

public class ElectricityOfferTest {
    private ElectricityOffer electricityOfferEmpty;
    private ElectricityOffer electricityOffer;

    @Before
    public void beforeTest() {
        System.out.println("ElectricityOffer test start");
        electricityOfferEmpty = new ElectricityOffer();
        int energy = 10;
        int price = 20;
        int hours = 3;
        ElectricityBlock electricityBlock = new ElectricityBlock(energy, price, hours);
        ArrayList<ElectricityBlock> listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        electricityOffer = new ElectricityOffer(listElectricityBlocks);
    }
}
