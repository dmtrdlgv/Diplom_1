package burgertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BurgerGetPriceParametrizedTest {

    private final float ingredientPrice;
    private final float bunPrice;
    private final float expectedBurgerPrice;
    private final int countIngredient;

    private Bun bun = Mockito.mock(Bun.class);
    private Ingredient ingredient = Mockito.mock(Ingredient.class);
    private float actualBurgerPrice;
    private Burger burger;

    public BurgerGetPriceParametrizedTest(float bunPrice, float ingredientPrice, float expectedBurgerPrice, int countIngredient) {
        this.ingredientPrice = ingredientPrice;
        this.bunPrice = bunPrice;
        this.expectedBurgerPrice = expectedBurgerPrice;
        this.countIngredient = countIngredient;
    }

    //В параметрах участвуют цены булочки, цены ингредиента, ожидаемая сумма и количество ингридиентов
    @Parameterized.Parameters(name = "цена булочки {0}, цена ингредиента {1}, ожидаемая сумма {2}, количество ингридиентов {3}")
    public static Object[][] getData() {
      return new Object[][] {
          {100.05f, 99.9f, 300, 1},
          {0, 0.111f, 0.222f, 2},
          {5000.555f, 0, 10001.11f, 3},
          {0, 0, 0, 1},
          {0.555f, 0, 1.11f, 0}
      };
    }

    @Test
    public void burgerGetPrice_withParameters_ExpectedPrice() {
        burger = new Burger();
        for (int i = 0; i < countIngredient; i++){
            burger.addIngredient(ingredient);
        }
        burger.setBuns(bun);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        actualBurgerPrice = burger.getPrice();
        assertEquals("Ожидаемая и фактическая цены бургера не совпали", expectedBurgerPrice, actualBurgerPrice, 0);
    }
}
