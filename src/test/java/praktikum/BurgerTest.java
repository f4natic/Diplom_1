package praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.constants.NameConstant;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient;

    @Mock
    private Ingredient anotherIngredient;

    @Spy
    private Burger burger;

    private Pattern bunPattern;
    private Pattern ingredientsPattern;

    @Before
    public void init() {
        bunPattern = Pattern.compile("\\(={4}\\s.{0,}\\s={4}\\)");
        ingredientsPattern = Pattern.compile("={1}\\s.{0,}\\s={1}");
    }

    @Test
    public void shouldSetBun() {
        burger.setBuns(bun);
        Assert.assertEquals(bun, burger.bun);
    }

    @Test
    public void shouldAddIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredient, burger.ingredients.get(0));
    }

    @Test
    public void shouldRemoveIngredientAtIndex() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue(burger.ingredients.isEmpty());
    }

    @Test
    public void shouldMoveIngredientAtIndex() {
        burger.addIngredient(ingredient);
        burger.addIngredient(anotherIngredient);
        burger.moveIngredient(0, 1);
        Assert.assertEquals(ingredient, burger.ingredients.get(1));
    }

    @Test
    public void shouldReturnPrice() {
        Mockito.when(bun.getPrice()).thenReturn(1.0f);
        Mockito.when(ingredient.getPrice()).thenReturn(1.0f);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float actual = burger.getPrice();
        Assert.assertEquals(3.0, actual, 0.0f);
    }

    @Test
    public void shouldReturnReciept() {
        Mockito.when(bun.getName()).thenReturn(NameConstant.BUN_NAME.getName());
        Mockito.when(ingredient.getName()).thenReturn(NameConstant.INGREDIENT_NAME.getName());
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);

        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        String[] strings = burger.getReceipt().trim().split("\n");
        for(int i =0; i < strings.length - 3; i++) {
            if(i == 0 || i == strings.length - 3) {
                Assert.assertTrue(bunPattern.matcher(strings[i]).find());
            }else {
                Assert.assertTrue(ingredientsPattern.matcher(strings[i]).find());
            }
        }
        Assert.assertTrue(strings[strings.length-1].contains("Price:"));
    }
}
