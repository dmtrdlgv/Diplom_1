package ingredienttypetest;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    private IngredientType type;

    @Test
    public void ingredientTypeHasItemSauceExpectedNotNull() {
        assertNotNull("Начинка не указана в ингредиентах", type.valueOf("SAUCE"));
    }

    @Test
    public void ingredientTypeHasItemFillingExpectedNotNull() {
        assertNotNull("Начинка не указана в ингредиентах", type.valueOf("FILLING"));
    }
}
