package ingredienttypetest;

import org.junit.Test;
import praktikum.IngredientType;

import static org.junit.Assert.assertNotNull;

public class IngredientTypeTest {

    private IngredientType type;

    @Test
    public void ingredientType_HasItemSauce_ExpectedNotNull() {
        assertNotNull("Начинка не указана в ингредиентах", type.valueOf("SAUCE"));
    }

    @Test
    public void ingredientType_HasItemFilling_ExpectedNotNull() {
        assertNotNull("Начинка не указана в ингредиентах", type.valueOf("FILLING"));
    }
}
