package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BunMockTest {
    @Mock
    Bun bun;

    @Test //проверка метода на получение имени
    public void getName() {
        when(bun.getName()).thenReturn("Булочка");
        assertEquals("Bun name should be: \"Булочка\"", "Булочка", bun.getName());
        Mockito.verify(bun, Mockito.times(1)).getName();
    }

    @Test //проверка метода на получение цены
    public void getPrice() {
        when(bun.getPrice()).thenReturn(1000F);
        assertEquals("Bun price should be: \"1000\"", 1000F, bun.getPrice(), 0.01F);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }
}