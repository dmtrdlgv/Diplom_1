package Ingredienttest;

import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.Random;

import static org.apache.commons.lang3.RandomStringUtils.*;
import static org.junit.Assert.*;

public class IngredientTest {

    private String ingredientName;
    private float ingredientPrice;
    private IngredientType ingredientType;
    private Ingredient ingredient;

    private float actualPrice;
    private String actualName;
    private IngredientType actualIngredientType;


    @Before
    public void init() {
        ingredientName = randomAlphabetic(5,15);
        ingredientPrice = new Random().nextFloat() * 1000;
        ingredient = new Ingredient(ingredientType.valueOf("SAUCE"), ingredientName, ingredientPrice);
    }

    @Test
    public void getPrice_FloatNum_ExpectedInitValue() {
        actualPrice = ingredient.getPrice();
        assertEquals(ingredientPrice, actualPrice, 0);
    }

    @Test
    public void getName_WithString_ExpectedInitValue() {
        actualName = ingredient.getName();
        assertEquals(ingredientName, actualName);
    }

    @Test
    public void getType_WithSauce_ExpectedInitValue() {
        actualIngredientType = ingredient.getType();
        assertEquals(ingredientType.valueOf("SAUCE"), actualIngredientType);
    }
}
