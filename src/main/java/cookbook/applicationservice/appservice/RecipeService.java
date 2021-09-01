package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.*;
import cookbook.domain.id.IngredientID;
import cookbook.domain.id.RecipeID;
import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidNameException;
import cookbook.util.Utils;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@AllArgsConstructor
public class RecipeService implements IRecipeService {

    @Autowired
    private final IRecipeRepository recipeRepository;
    @Autowired
    private final RecipeIDGenerator recipeIDGenerator;
    @Autowired
    private final IngredientIDGenerator ingredientIDGenerator;


    /**
     * Method that creates a new Recipe.
     *
     * @param newRecipe - DTO with all the information to create a new recipe
     * @return a OUT DTO with the title of the recipe that was created
     */
    public NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe) throws InvalidNameException {
        RecipeID recipeID = recipeIDGenerator.generates();
        RecipeTitle title = new RecipeTitle(newRecipe.getTitle());
        MealType mealType = MealType.valueOf(newRecipe.getMealType());
        int numberOfPerson = Integer.parseInt(newRecipe.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(newRecipe.getDifficultyLevel());
        List<String> ingredientsList = newRecipe.getIngredientsList();
        List<Ingredient> ingredientListParsed = splitListOfIngredients(ingredientsList);
        String preparationSteps = newRecipe.getPreparationSteps();

        Recipe recipe = new Recipe(recipeID,title, mealType, numberOfPerson, difficultyLevel, ingredientListParsed, preparationSteps);

        recipeRepository.save(recipe);

        return new NewRecipeOutDTO(recipe.getTitle().toString());
    }

    /**
     * Method that receives a list of strings with all the ingredients and splits them and returns a list of ingredients.
     *
     * @param ingredients - list of strings
     * @return a list of ingredients
     */
    private List<Ingredient> splitListOfIngredients(List<String> ingredients) throws InvalidNameException {
        List<Ingredient> listOfIngredients = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient parsedIngredient = splitIngredient(ingredients.get(i));
            listOfIngredients.add(parsedIngredient);
        }
        return listOfIngredients;
    }

    /**
     * Method that receives a string, splits the name and the measure unit and creates a Ingredient with the correct information.
     *
     * @param ingredient - string with the name and measure unit
     * @return an Ingredient
     */
    private Ingredient splitIngredient(String ingredient) throws InvalidNameException {
        //Divide, pela espaço, a String ingredient em duas partes
        List<String> ingredients = Arrays.asList(ingredient.split(" "));
        //Divide a primeira string da lista ingredients em números e letras
        MeasureUnity measureUnity = Utils.splitMeasureUnity(ingredients.get(1));
        IngredientID id = ingredientIDGenerator.generates();
        return new Ingredient(id,ingredients.get(0), measureUnity);
    }
}
