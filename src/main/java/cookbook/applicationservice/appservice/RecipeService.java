package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.*;
import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class RecipeService implements IRecipeService{

    @Autowired
    private final  IRecipeRepository recipeRepository;


    /**
     *
     * @param newRecipe
     * @return
     */
    public NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe){
        String title = newRecipe.getTitle();
        MealType mealType = MealType.valueOf(newRecipe.getMealType());
        int numberOfPerson = Integer.parseInt(newRecipe.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(newRecipe.getDifficultyLevel());
        List<String> ingredientsList = newRecipe.getIngredientsList();
        List<String> preparationStepsList = newRecipe.getPreparationStepsList();




    }

    /**
     *
     * @param ingredient
     * @return
     */
    private Ingredient splitIngredient(String ingredient){
        //Divide, pela vírgula, a String ingredient em duas partes
        List<String> ingredients = Arrays.asList(ingredient.split(","));
        //Divide a primeira string da lista ingredients em números e letras
        String[]  measures = ingredients.get(0).split(" (\\d+)(\\w+)");
        String amount = measures[0];
        String measureUnit = measures[1];
        MeasureUnity measureUnity = new MeasureUnity(Integer.parseInt(amount),measureUnit);
        return new Ingredient(ingredients.get(1),measureUnity);

    }

}
