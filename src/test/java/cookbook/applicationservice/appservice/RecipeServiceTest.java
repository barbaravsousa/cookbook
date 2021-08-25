package cookbook.applicationservice.appservice;


import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RecipeServiceTest {

    @Autowired
    RecipeService recipeService;

    @Test
    public void createNewRecipeSuccess() throws InvalidNameException {
        List<String> ingredients=new ArrayList<>();
        ingredients.add("Massa meada 100g");
        ingredients.add("Bacalhau 1kg");
        ingredients.add("Feijão 20g");
        ingredients.add("Cenoura 159g");

        String steps="Junte os feijões e a cenoura.No fim junte o bacalhau e sirva com molho";

        NewRecipeDTO newRecipeDTO = new NewRecipeDTO("Massa com bacalhau","MEAL","4","BEGINNER",ingredients,steps);

        NewRecipeOutDTO recipe = recipeService.createNewRecipe(newRecipeDTO);

        assertNotNull(recipe);
        assertEquals("Massa com bacalhau", recipe.getTitle());


    }

}