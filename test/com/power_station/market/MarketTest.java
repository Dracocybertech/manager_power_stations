package test.com.power_station.market;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.power_station.market.Market;
import com.power_station.market.MarketAlreadyExistingException;
import com.power_station.offer.ElectricityBlock;
import com.power_station.offer.ElectricityOffer;

public class MarketTest {

    private Market emptyMarket;
    private Market market;
    private ElectricityOffer electricityOffer;
    private ArrayList<ElectricityBlock> listElectricityBlocks;

    @Before
    public void beforeTest() {
        System.out.println("Market Test start");
        emptyMarket = new Market("Primaire");
        int energy = 10;
        int price = 20;
        int hours = 3;
        ElectricityBlock electricityBlock = new ElectricityBlock(energy, price, hours);
        listElectricityBlocks = new ArrayList<>();
        listElectricityBlocks.add(electricityBlock);
        electricityOffer = new ElectricityOffer(listElectricityBlocks);
        market = new Market("Secondaire", electricityOffer);
    }

    @Test(expected=MarketAlreadyExistingException.class)
    public void marketAlreadyExistingExceptionTest() {
        new Market(market.getName());
    }
}
