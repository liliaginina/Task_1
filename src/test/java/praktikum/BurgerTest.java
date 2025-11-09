package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun mockBun;

    @Mock
    private Ingredient mockIngredient1;

    @Mock
    private Ingredient mockIngredient2;

    private Burger burger;

    @Before
    public void setUp() {
        burger = new Burger();
    }

    @Test
    public void setBunsSetsBunCorrectly() {
        burger.setBuns(mockBun);
        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void addIngredientAddsIngredientToList() {
        burger.addIngredient(mockIngredient1);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
    }

    @Test
    public void addIngredientAddsMultipleIngredientsToList() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        assertEquals(2, burger.ingredients.size());
        assertEquals(mockIngredient1, burger.ingredients.get(0));
        assertEquals(mockIngredient2, burger.ingredients.get(1));
    }

    @Test
    public void removeIngredientRemovesIngredientByIndex() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.removeIngredient(0);
        assertEquals(1, burger.ingredients.size());
        assertEquals(mockIngredient2, burger.ingredients.get(0));
    }

    @Test
    public void moveIngredientMovesIngredientToNewIndex() {
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);
        burger.moveIngredient(0, 1);
        assertEquals(mockIngredient2, burger.ingredients.get(0));
        assertEquals(mockIngredient1, burger.ingredients.get(1));
    }

    @Test
    public void getPriceCalculatesPriceWithBunOnly() {
        when(mockBun.getPrice()).thenReturn(50.0f);
        burger.setBuns(mockBun);

        float expectedPrice = 100.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);
        verify(mockBun, times(1)).getPrice();
    }

    @Test
    public void getPriceCalculatesPriceWithBunAndIngredients() {
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getPrice()).thenReturn(100.0f);
        when(mockIngredient2.getPrice()).thenReturn(200.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        float expectedPrice = 50.0f * 2 + 100.0f + 200.0f;
        assertEquals(expectedPrice, burger.getPrice(), 0.01f);

        verify(mockBun, times(1)).getPrice();
        verify(mockIngredient1, times(1)).getPrice();
        verify(mockIngredient2, times(1)).getPrice();
    }

    @Test
    public void getReceiptGeneratesCorrectReceipt() {
        when(mockBun.getName()).thenReturn("Black bun");
        when(mockBun.getPrice()).thenReturn(50.0f);
        when(mockIngredient1.getName()).thenReturn("Cutlet");
        when(mockIngredient1.getType()).thenReturn(IngredientType.FILLING);
        when(mockIngredient1.getPrice()).thenReturn(100.0f);
        when(mockIngredient2.getName()).thenReturn("Hot sauce");
        when(mockIngredient2.getType()).thenReturn(IngredientType.SAUCE);
        when(mockIngredient2.getPrice()).thenReturn(50.0f);

        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("(==== Black bun ====)"));
        assertTrue(receipt.contains("= filling Cutlet ="));
        assertTrue(receipt.contains("= sauce Hot sauce ="));
        assertTrue(receipt.contains("Price: 250"));

        verify(mockBun, atLeast(2)).getName();
        verify(mockIngredient1, times(1)).getName();
        verify(mockIngredient1, times(1)).getType();
        verify(mockIngredient2, times(1)).getName();
        verify(mockIngredient2, times(1)).getType();
    }

    @Test
    public void getReceiptGeneratesCorrectReceiptWithoutIngredients() {
        when(mockBun.getName()).thenReturn("White bun");
        when(mockBun.getPrice()).thenReturn(100.0f);

        burger.setBuns(mockBun);

        String receipt = burger.getReceipt();

        assertTrue(receipt.contains("(==== White bun ====)"));
        assertTrue(receipt.contains("Price: 200"));

        verify(mockBun, atLeast(2)).getName();
        verify(mockBun, times(1)).getPrice();
    }
}
