package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static praktikum.Constants.DELTA;

@RunWith(MockitoJUnitRunner.class)
public class BunTest {
    @Mock
    Database database;

    @Test //проверка метода на получение имени
    public void getName() {
        Bun expectedBun = new Bun("black bun", 300F);
        when(database.availableBuns()).thenReturn(List.of(expectedBun));
        Bun bun = new Bun(database.availableBuns().get(0).name, database.availableBuns().get(0).price);
        assertEquals("Bun name should be: \"black bun\"", "black bun", bun.getName());
    }

    @Test //проверка метода на получение цены
    public void getPrice() {
        Bun expectedBun = new Bun("black bun", 300F);
        when(database.availableBuns()).thenReturn(List.of(expectedBun));
        Bun bun = new Bun(database.availableBuns().get(0).name, database.availableBuns().get(0).price);
        assertEquals("Bun price should be: \"300\"", 300F, bun.getPrice(), DELTA);
    }
}