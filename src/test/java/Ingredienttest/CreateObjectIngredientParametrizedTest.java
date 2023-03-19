package Ingredienttest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class CreateObjectIngredientParametrizedTest {

    private final IngredientType ingredientType;
    private final String ingredientName;
    private final float ingredientPrice;
    private Ingredient ingredient;


    public CreateObjectIngredientParametrizedTest(IngredientType ingredientType, String ingredientName, float ingredientPrice) {
        this.ingredientType = ingredientType;
        this.ingredientName = ingredientName;
        this.ingredientPrice = ingredientPrice;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}; \"{1}\"; {2}")
    public static Object[][] getData() {
        return new Object[][] {
            {SAUCE, "Тестовый ингридиент", 1111.1111f},
            {SAUCE, " ", 1111.1111f},
            {SAUCE, "", 1111.1111f},
            {SAUCE, null, 1111.1111f},
            {FILLING, "Тестовый ингридиент", Float.MAX_VALUE},
            {FILLING, "Тестовый ингридиент", Float.MIN_VALUE},
            {FILLING, "Тестовый ингридиент", 0},
            {FILLING, "Тестовый ингридиент", -1},
            {null, "Тестовый ингридиент", 1111.1111f}
        };
    }

    @Test
    public void createNewIngredient_ExpectedNotNull() {
        ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);
        assertNotNull(ingredient);
    }
}
