package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {

    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> bunTestData() {
        return Arrays.asList(new Object[][]{
                {"Black bun", 100.0f},
                {"White bun", 200.0f},
                {"Red bun", 300.0f}
        });
    }

    @Test
    public void bunConstructorSetsNameCorrectly() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void bunConstructorSetsPriceCorrectly() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.01f);
    }

    @Test
    public void getNameReturnsCorrectName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), 0.01f);
    }
}
