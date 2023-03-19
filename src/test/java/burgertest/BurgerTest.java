package burgertest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    private int actualListSize;
    private String actualReceipt;
    private String expectedReceipt;

    @Mock
    Bun bun;
    @Mock
    Ingredient firstIngredient;
    @Mock
    Ingredient secondIngredient;
    @Mock
    Ingredient thirdIngredient;

    @Before
    public void init() {
        burger = new Burger();
    }

    @Test
    public void setBuns_WithBunObject_ExpectedBurgerBunNotNull() {
        burger.setBuns(bun);
        assertNotNull("Булочки bun не добавлены в burger.bun",burger.bun);
    }

    @Test
    public void addIngredient_WithIngredientObject_ExpectedBurgerIngredientNotNull() {
        burger.addIngredient(firstIngredient);
        assertNotNull("Ingredient в burger.ingredients is NULL!",burger.ingredients.get(0));
    }

    @Test
    public void addIngredient_WithIngredientObject_ExpectedBurgerIngredientListHasNewItem() {
        burger.addIngredient(firstIngredient);
        assertEquals("Ingredient не добавлен в burger.ingredients",burger.ingredients.size(),1);
    }

    @Test
    public void removeIngredient_WithOneItem_ExpectedZeroItemsInList() {
        burger.addIngredient(firstIngredient);
        actualListSize = burger.ingredients.size();
        burger.removeIngredient(0);
        assertEquals("Из списка ингредиентов не удаляется ингридиент", actualListSize - 1,0);
    }

    //Тест на проверку удаления определенного ингредиента из списка
    @Test
    public void removeIngredient_WithTwoItems_ExpectedOnlyFirstItem() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.removeIngredient(0);
        assertEquals("Из списка ингредиентов удаляется не заданный ингридиент",
                secondIngredient, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredient_FromSecondToFirst_ExpectedSwitchItemIndex() {
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        burger.addIngredient(thirdIngredient);
        burger.moveIngredient(1,0);
        assertTrue("Item index has not switched",burger.ingredients.get(0) == secondIngredient &&
                burger.ingredients.get(1) == firstIngredient && burger.ingredients.get(2) == thirdIngredient);
    }

    @Test
    public void getReceipt_WithBunAndIngredients_ExpectedStringWithAllItems() {
        Mockito.when(bun.getName()).thenReturn("Булочка с кунжутом");
        Mockito.when(bun.getPrice()).thenReturn(100f);
        Mockito.when(firstIngredient.getType()).thenReturn(IngredientType.SAUCE);
        Mockito.when(firstIngredient.getName()).thenReturn("Кетчуп");
        Mockito.when(firstIngredient.getPrice()).thenReturn(100f);
        Mockito.when(secondIngredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(secondIngredient.getName()).thenReturn("Листья салата");
        Mockito.when(secondIngredient.getPrice()).thenReturn(50f);

        expectedReceipt = "(==== Булочка с кунжутом ====)\r\n" +
                "= sauce Кетчуп =\r\n" +
                "= filling Листья салата =\r\n" +
                "(==== Булочка с кунжутом ====)\r\n" +
                "\r\n" +
                "Price: 350,000000\r\n";

        burger.setBuns(bun);
        burger.addIngredient(firstIngredient);
        burger.addIngredient(secondIngredient);
        actualReceipt = burger.getReceipt();
        assertEquals(expectedReceipt, actualReceipt);
    }
}
