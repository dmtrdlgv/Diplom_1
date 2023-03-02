package burgertest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private int actualListSize;

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;

    @Test
    public void setBuns_WithBunObject_ExpectedBurgerBunNotNull() {
        burger = new Burger();
        burger.setBuns(bun);
        assertNotNull("Булочки bun не добавлены в burger.bun",burger.bun);
    }

    @Test
    public void addIngredient_WithIngredientObject_ExpectedBurgerIngredientNotNull() {
        burger = new Burger();
        burger.addIngredient(firstIngredient);
        assertNotNull("Ingredient в burger.ingredients is NULL!",burger.ingredients.get(0));
    }

    @Test
    public void addIngredient_WithIngredientObject_ExpectedBurgerIngredientListHasNewItem() {
        burger = new Burger();
        burger.addIngredient(firstIngredient);
        assertEquals("Ingredient не добавлен в burger.ingredients",burger.ingredients.size(),1);
    }

    @Test
    public void removeIngredient_WithOneItem_ExpectedZeroItemsInList() {
        burger = new Burger();
        burger.addIngredient(firstIngredient);
        actualListSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("Из списка ингредиентов не удаляется ингридиент", actualListSize,0);
    }

    //Тест на проверку удаления определенного ингредиента из списка
    @Test
    public void removeIngredient_WithTwoItems_ExpectedOnlyFirstItem() {
        burger = new Burger();
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals("Из списка ингредиентов удаляется не заданный ингридиент",
                secondIngredient, burger.ingredients.get(0));
    }
}
