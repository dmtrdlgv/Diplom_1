package Ingredienttest;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class CreateObjectIngredientParametrizedTest {

    public IngredientType type;
    public String name;
    public float price;
}
