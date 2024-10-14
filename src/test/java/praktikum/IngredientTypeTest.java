package praktikum;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class IngredientTypeTest {

    @Test //проверка, что в элементе присутствуют те типы, которые и ожидаются
    public void valuesTypeOfIngredient() {
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};
        assertThat(IngredientType.values(), equalTo(expectedTypes));
    }

    @Test //Проверка, что в константе верное содержание
    public void valueOfIngredientSauce() {
        assertThat(IngredientType.SAUCE, is(IngredientType.valueOf("SAUCE")));
    }

    @Test //Проверка, что в константе верное содержание
    public void valueOfIngredientFiling() {
        assertThat(IngredientType.FILLING, is(IngredientType.valueOf("FILLING")));
    }
}