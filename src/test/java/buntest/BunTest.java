package buntest;

import org.junit.Before;
import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String bunName = "Тестовая булочка";
    private final float bunPrice = 1111.1111f;
    private String actualBunName;
    private float actualBunPrice;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(bunName, bunPrice);
    }

    @Test
    public void getNameExpectedBunName() {
        actualBunName = bun.getName();
        assertEquals(bunName, actualBunName);
    }

    @Test
    public void getPriceExpectedBunPrice() {
        actualBunPrice = bun.getPrice();
        assertEquals(bunPrice, actualBunPrice, 0);
    }
}
