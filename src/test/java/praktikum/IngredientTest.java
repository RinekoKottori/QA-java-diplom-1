package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {
    static Database data = new Database();
    private final IngredientType type;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters //получения данных обо всех возможных ингредиентов
    public static Object[][] getAnIngredient() {
        return new Object[][]{
                {data.availableIngredients().get(0).type, data.availableIngredients().get(0).name, data.availableIngredients().get(0).price},
                {data.availableIngredients().get(1).type, data.availableIngredients().get(1).name, data.availableIngredients().get(1).price},
                {data.availableIngredients().get(2).type, data.availableIngredients().get(2).name, data.availableIngredients().get(2).price},
                {data.availableIngredients().get(3).type, data.availableIngredients().get(3).name, data.availableIngredients().get(3).price},
                {data.availableIngredients().get(4).type, data.availableIngredients().get(4).name, data.availableIngredients().get(4).price},
                {data.availableIngredients().get(5).type, data.availableIngredients().get(5).name, data.availableIngredients().get(5).price}
        };
    }

    @Test //проверка корректности получения цены каждого ингредиента
    public void getPrice() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(price, ingredient.getPrice(), 0.01);
    }

    @Test //проверка корректности получения названия каждого ингредиента
    public void getName() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(name, ingredient.getName());
    }

    @Test //проверка корректности получения типа каждого ингредиента
    public void getType() {
        Ingredient ingredient = new Ingredient(type, name, price);
        assertEquals(type, ingredient.getType());
    }
}