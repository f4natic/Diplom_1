package praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.constants.NameConstant;
import praktikum.utils.NameGenerator;
import praktikum.utils.PriceGenerator;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType type;
    private final String name;
    private final float price;

    private Ingredient ingredient;

    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.price = price;

        ingredient = new Ingredient(type, name, price);
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                {IngredientType.FILLING, NameGenerator.generateName(NameConstant.INGREDIENT_NAME.getName()), PriceGenerator.generatePrice()},
                {IngredientType.SAUCE, NameGenerator.generateName(NameConstant.INGREDIENT_NAME.getName()), PriceGenerator.generatePrice()},
        };
    }

    @Test
    public void shouldReturnIngredientType() {
        IngredientType actual = ingredient.getType();
        Assert.assertEquals("Типы ингредиентов не совпадают", type, actual);
    }

    @Test
    public void shouldReturnIngredientName() {
        String actual = ingredient.getName();
        Assert.assertEquals("Имена ингредиентов не совпадают", name, actual);
    }

    @Test
    public void shouldReturnIngredientPrice() {
        float actual = ingredient.getPrice();
        Assert.assertEquals(price, actual, 0.0f);
    }
}
