package cookbook.domain;

import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecipeTitleTest {

    @Test
    public void recipeTitle_Success() throws InvalidNameException {
        RecipeTitle recipeTitle=new RecipeTitle("Massa com salsichas");
        assertNotNull(recipeTitle);
    }
    @Test
    public void recipeTitle_FailureNull(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(null));
    }
    @Test
    public void recipeTitle_FailureEmpty(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(""));
    }
    @Test
    public void recipeTitle_FailureBlank(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle(" "));
    }
    @Test
    public void recipeTitle_FailureInvalidTitle(){
        assertThrows(InvalidNameException.class, () -> new RecipeTitle("344 com queijo"));
    }

}