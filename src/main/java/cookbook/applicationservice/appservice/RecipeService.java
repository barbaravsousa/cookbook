package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.*;
import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidRecipeTitleException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class RecipeService implements IRecipeService {

    @Autowired
    private final IRecipeRepository recipeRepository;


    /**
     * @param newRecipe
     * @return
     */
    public NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe) throws InvalidRecipeTitleException {
        RecipeTitle title = new RecipeTitle(newRecipe.getTitle());
        MealType mealType = MealType.valueOf(newRecipe.getMealType());
        int numberOfPerson = Integer.parseInt(newRecipe.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(newRecipe.getDifficultyLevel());
        List<String> ingredientsList = newRecipe.getIngredientsList();
        List<Ingredient> ingredientListParsed = splitListOfIngredients(ingredientsList);
        List<String> preparationStepsList = newRecipe.getPreparationStepsList();

        Recipe recipe = new Recipe(title, mealType, numberOfPerson, difficultyLevel, ingredientListParsed, preparationStepsList);

        //É preciso guardar na BASE DE DADOS

        return new NewRecipeOutDTO(recipe.getTitle().toString());
    }

    /**
     * @param ingredients
     * @return
     */
    private List<Ingredient> splitListOfIngredients(List<String> ingredients) {
        List<Ingredient> listOfIngredients = new ArrayList<>();

        for (int i = 0; i < ingredients.size(); i++) {
            Ingredient parsedIngredient = splitIngredient(ingredients.get(i));
            listOfIngredients.add(parsedIngredient);
        }
        return listOfIngredients;
    }

    /**
     * @param ingredient
     * @return
     */
    private Ingredient splitIngredient(String ingredient) {
        //Divide, pela espaço, a String ingredient em duas partes
        List<String> ingredients = Arrays.asList(ingredient.split(" "));
        //Divide a primeira string da lista ingredients em números e letras
        Pattern pattern = Pattern.compile("(\\d+)(\\w+)");
        Matcher matcher = pattern.matcher(ingredients.get(0));
        if (matcher.find()) {
            String amount = matcher.group(1);
            String measureUnit = matcher.group(2);
            MeasureUnity measureUnity = new MeasureUnity(Integer.parseInt(amount),measureUnit);
            return new Ingredient(ingredients.get(1),measureUnity);
        }
        return null;
    }


}
