package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.*;
import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService implements IRecipeService{

    @Autowired
    private final  IRecipeRepository recipeRepository;


    public NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe){
        String title = newRecipe.getTitle();
        MealType mealType = MealType.valueOf(newRecipe.getMealType());
        int numberOfPerson = Integer.parseInt(newRecipe.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(newRecipe.getDifficultyLevel());
        List<String> ingredientsList = newRecipe.getIngredientsList();
        List<String> preparationStepsList = newRecipe.getPreparationStepsList();


        return null;

    }

}
