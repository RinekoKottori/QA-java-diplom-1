package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Parameterized.class)
public class IngredientTypeTest {
private final IngredientType type;
private final IngredientType expectedType;

    public IngredientTypeTest(IngredientType type, IngredientType expectedType) {
        this.type = type;
        this.expectedType = expectedType;
    }

@Parameterized.Parameters
public static Object[][] ingredientType() {
    return new Object[][]{
            {IngredientType.SAUCE, IngredientType.SAUCE},
            {IngredientType.FILLING, IngredientType.FILLING}
    };
}

    @Test //проверка, что в элементе присутствуют те типы, которые и ожидаются
    public void valuesTypeOfIngredient() {
        IngredientType[] expectedTypes = {IngredientType.SAUCE, IngredientType.FILLING};
        assertThat(IngredientType.values(), equalTo(expectedTypes));
    }

    @Test //Проверка, что в константе верное содержание
    public void valueOfIngredientSauce() {
        assertThat(expectedType, equalTo(IngredientType.valueOf(type.name())));
    }

}