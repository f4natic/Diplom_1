package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BunTest {

    private final String NAME = "Test Name";
    private final Float PRICE = 1.55f;
    private Bun bun;

    @Before
    public void init() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void shouldReturnName() {
        String actual = bun.getName();
        Assert.assertEquals("Возвращаемое название не соответствует ожидаемому",NAME,actual);
    }

    @Test
    public void shouldReturnPrice() {
        Float actual = bun.getPrice();
        Assert.assertEquals("Возвращаемая стоимость не соответствует ожидаемой",PRICE,actual);
    }
}
