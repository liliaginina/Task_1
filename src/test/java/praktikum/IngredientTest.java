package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType expectedType;
    private final String expectedName;
    private final float expectedPrice;

    public IngredientTest(IngredientType expectedType, String expectedName, float expectedPrice) {
        this.expectedType = expectedType;
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> ingredientTestData() {
        return Arrays.asList(new Object[][]{
                {IngredientType.SAUCE, "Hot sauce", 100.0f},
                {IngredientType.SAUCE, "Sour cream", 200.0f},
                {IngredientType.FILLING, "Cutlet", 100.0f},
                {IngredientType.FILLING, "Dinosaur", 200.0f}
        });
    }

    @Test
    public void ingredientConstructorSetsTypeCorrectly() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void ingredientConstructorSetsNameCorrectly() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void ingredientConstructorSetsPriceCorrectly() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.01f);
    }

    @Test
    public void getTypeReturnsCorrectType() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedType, ingredient.getType());
    }

    @Test
    public void getNameReturnsCorrectName() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Ingredient ingredient = new Ingredient(expectedType, expectedName, expectedPrice);
        assertEquals(expectedPrice, ingredient.getPrice(), 0.01f);
    }
}
