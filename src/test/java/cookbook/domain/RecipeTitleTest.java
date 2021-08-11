package cookbook.domain;

import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTitleTest {

    @Test
    public void recipeTitleSuccess() throws InvalidNameException {
        RecipeTitle recipeTitle=new RecipeTitle("Massa com salsichas");
        assertNotNull(recipeTitle);
    }
    @Test
    public void recipeTitleFailureNull(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(null));
    }
    @Test
    public void recipeTitleFailureEmpty(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(""));
    }
    @Test
    public void recipeTitleFailureBlank(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(" "));
    }
    @Test
    public void recipeTitleFailureInvalidTitle(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle("344 com queijo"));
    }

}