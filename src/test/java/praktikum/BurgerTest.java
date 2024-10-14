package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BurgerTest {

    private Burger burger;
    private Ingredient ingredient;


    @Test //проверка добавления булочки
    public void checkBunInBurger() {
        burger = new Burger();
        burger.setBuns(new Bun("Bread", 100.0F)); //создание булочки с параметрами
        assertEquals("Bread", burger.bun.getName());
    }

    @Test //проверка добавления ингредиентов
    public void checkIsIngredientAdds() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120.0F); //создание ингредиента
        burger.addIngredient(ingredient); //добавление ингредиента в список
        assertTrue(burger.ingredients.contains(ingredient));

        assertEquals(burger.ingredients.size(), 1);
    }

    @Test //проверка удаления ингредиентов
    public void checkIsIngredientRemoves() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120.0F); //создание ингредиента
        burger.addIngredient(ingredient); //добавление ингредиента в список
        burger.removeIngredient(0); //удаление первого ингредиента в списке

        assertEquals(burger.ingredients.size(), 0);
    }

    @Test //проверка перемещения ингредиентов
    public void checkIsIngredientMoves() {
        burger = new Burger();
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120.0F); //создание ингредиента №1
        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "marmalade", 130.0F); //создание ингредиента №2
        burger.addIngredient(ingredient); //добавление ингредиента №1 в список
        burger.addIngredient(ingredient1); //добавление ингредиента №2 в список
        burger.moveIngredient(0, 1);

        assertEquals("sour cream", burger.ingredients.get(1).getName());
    }

    @Test //проверка стоимости бургера
    public void checkIsPriceGets() {
        burger = new Burger();
        burger.setBuns(new Bun("Bread", 100.0F)); //создание булочки с параметрами
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120.0F); //создание ингредиента
        burger.addIngredient(ingredient); //добавление ингредиента в список

        assertEquals(320.0F, burger.getPrice(), 0.01);
    }

    @Test //проверка выдачи чека
    public void checkIsReceiptCorrect() {
        burger = new Burger();
        burger.setBuns(new Bun("Bread", 100.0F)); //создание булочки с параметрами
        ingredient = new Ingredient(IngredientType.SAUCE, "sour cream", 120.0F); //создание ингредиента №1
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "marmalade", 130.0F); //создание ингредиента №2
        burger.addIngredient(ingredient); //добавление ингредиента №1 в список
        burger.addIngredient(ingredient1); //добавление ингредиента №2 в список

        //создание ожидаемой строки
        String expectedFormatString = String.format(("(==== %s ====)%n"), burger.bun.getName()) +
                String.format("= sauce sour cream =%n") +
                String.format("= filling marmalade =%n") +
                String.format(("(==== %s ====)%n"), burger.bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());

        assertEquals(expectedFormatString, burger.getReceipt());
    }

}