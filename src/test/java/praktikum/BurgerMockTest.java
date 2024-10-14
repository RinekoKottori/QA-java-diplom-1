package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerMockTest {
    @Mock
    Burger burger;
    Ingredient ingredient;
    Bun bun;

    @Test //проверка добавления булочки
    public void checkBunInBurger() {
        burger.setBuns(bun);
        verify(burger).setBuns(bun);
    }

    @Test //проверка добавления ингредиентов
    public void checkIsIngredientAdds() {
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120);
        doNothing().when(burger).addIngredient(any(Ingredient.class));
        burger.addIngredient(ingredient);
        verify(burger).addIngredient(ingredient);
    }

    @Test //проверка удаления ингредиентов
    public void checkIsIngredientRemoves() {
        doNothing().when(burger).removeIngredient(anyInt());
        burger.removeIngredient(0);
        verify(burger).removeIngredient(0);
    }

    @Test //проверка перемещения ингредиентов
    public void checkIsIngredientMoves() {
        doNothing().when(burger).moveIngredient(anyInt(), anyInt());
        burger.moveIngredient(0, 1);
        verify(burger).moveIngredient(0, 1);
    }

    @Test //проверка стоимости бургера
    public void checkIsPriceGets() {
        burger.getPrice();
        verify(burger).getPrice();
    }

    @Test //проверка выдачи чека
    public void checkIsReceiptCorrect() {
        burger.getReceipt();
        verify(burger).getReceipt();
    }
}