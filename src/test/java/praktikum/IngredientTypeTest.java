package praktikum;

import org.junit.Test;
import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void ingredientTypeHasSauceValue() {
        IngredientType type = IngredientType.SAUCE;
        assertNotNull(type);
        assertEquals("SAUCE", type.name());
    }

    @Test
    public void ingredientTypeHasFillingValue() {
        IngredientType type = IngredientType.FILLING;
        assertNotNull(type);
        assertEquals("FILLING", type.name());
    }

    @Test
    public void ingredientTypeValuesReturnsAllTypes() {
        IngredientType[] types = IngredientType.values();
        assertEquals(2, types.length);
    }

    @Test
    public void ingredientTypeValueOfReturnsSauce() {
        IngredientType type = IngredientType.valueOf("SAUCE");
        assertEquals(IngredientType.SAUCE, type);
    }

    @Test
    public void ingredientTypeValueOfReturnsFilling() {
        IngredientType type = IngredientType.valueOf("FILLING");
        assertEquals(IngredientType.FILLING, type);
    }
}
