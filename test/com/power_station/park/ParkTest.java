package test.com.power_station.park;

import java.util.ArrayList;

import org.junit.Before;

import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;
import com.power_station.park.Park;

public class ParkTest {

    private Park emptyPark;
    private Park park;
    private ArrayList<ElectricityBlock> listElectricityBlocks;

    @Before
    public void beforeTest() {
        System.out.println("Park test starting");
        emptyPark = new Park("Primaire", "Empty Park");
        
        int energy = 10;
        int price = 20;
        int hours = 3;
        ElectricityBlock electricityBlock = new ElectricityBlock(energy, price, hours);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        park = new Park("Primaire", "Park 1",listElectricityBlocks);
    }

}
