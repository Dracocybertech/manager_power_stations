package test.com.power_station.offer;

import org.junit.Before;

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
}
