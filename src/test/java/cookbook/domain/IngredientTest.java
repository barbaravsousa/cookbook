package cookbook.domain;

import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class IngredientTest {

    @Test
    public void newIngredientSuccess() throws InvalidNameException {
        MeasureUnity measureUnity = new MeasureUnity(20,"g");
        Ingredient ingredient = new Ingredient("Queijo",measureUnity);
        assertNotNull(ingredient);
    }

    @Test
    public void IngredientFailureNull(){
        assertThrows(InvalidNameException.class, () -> new Ingredient(null,null));
    }

    @Test
    public void IngredientFailure() throws InvalidNameException {
        MeasureUnity measureUnity = new MeasureUnity(20,"g");
        assertThrows(InvalidNameException.class, () -> new Ingredient("Que87237",measureUnity));
    }




}