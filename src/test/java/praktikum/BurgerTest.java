package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Ingredient ingredient;
    Ingredient ingredient2;
    @Mock
    Bun bun;

    @Test //проверка добавления булочки
    public void checkBunInBurger() {
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(50F);
        burger.setBuns(bun);
        float bunPrice = burger.getPrice();
        verify(bun).getPrice();
        assertThat(50F * 2, equalTo(bunPrice));
    }

    @Test //проверка добавления ингредиентов
    public void checkIsIngredientAdds() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        verify(ingredient, never()).getPrice();
        assertTrue(burger.ingredients.contains(ingredient));
    }

    @Test //проверка удаления ингредиентов
    public void checkIsIngredientRemoves() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        verify(ingredient, never()).getPrice();
        assertTrue(burger.ingredients.isEmpty());
    }

    @Test //проверка перемещения ингредиентов
    public void checkIsIngredientMoves() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0,1);
        assertThat(ingredient, equalTo(burger.ingredients.get(1)));
    }

    @Test //проверка стоимости бургера
    public void checkIsPriceGets() {
        Burger burger = new Burger();
        when(bun.getPrice()).thenReturn(300F);
        when(ingredient.getPrice()).thenReturn(150F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float expectedPrice = 300F * 2 + 150F;
        assertThat(expectedPrice, equalTo(burger.getPrice()));

    }

    @Test //проверка выдачи чека
    public void checkIsReceiptCorrect() {
       Burger burger = new Burger();
       when(bun.getName()).thenReturn("Bulochka");
       when(bun.getPrice()).thenReturn(150F);
       when(ingredient.getType()).thenReturn(IngredientType.valueOf("FILLING"));
       when(ingredient.getName()).thenReturn("marmalade");
       when(ingredient.getPrice()).thenReturn(500F);


        burger.setBuns(bun);
        burger.addIngredient(ingredient); //добавление ингредиента №1 в список

        //создание ожидаемой строки
        String expectedFormatString = String.format(("(==== %s ====)%n"), burger.bun.getName()) +
                String.format("= filling marmalade =%n") +
                String.format(("(==== %s ====)%n"), burger.bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedFormatString, burger.getReceipt());
    }
}