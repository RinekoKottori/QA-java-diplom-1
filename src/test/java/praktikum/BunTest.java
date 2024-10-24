package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static praktikum.Constants.DELTA;


public class BunTest {

    @Test //проверка получения верного названия булочки
    public void getName() {
        Database data = new Database();
        Bun bun = new Bun(data.availableBuns().get(0).name, data.availableBuns().get(0).price);
        assertEquals("Bun name should be: \"black bun\"", "black bun", bun.getName());
    }

    @Test  //проверка получения верной цены булочки
    public void getPrice() {
        Database data = new Database();
        Bun bun = new Bun(data.availableBuns().get(2).name, data.availableBuns().get(2).price);
        assertEquals("Bun price should be: \"300\"", 300, bun.getPrice(), DELTA);
    }
}