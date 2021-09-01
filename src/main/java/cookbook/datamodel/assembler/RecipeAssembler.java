package cookbook.datamodel.assembler;

import cookbook.datamodel.IngredientJPA;
import cookbook.datamodel.RecipeJPA;
import cookbook.domain.*;
import cookbook.domain.id.RecipeID;
import cookbook.dto.todomaindto.RecipeJPAToDomainDTO;
import cookbook.exception.InvalidNameException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeAssembler {

    /**
     * Method that receives a data model object and transforms it into a domain object.
     *
     * @param recipeJPA - data model object
     * @return a domain DTO with the information needed to create a domain object
     * @throws InvalidNameException if the title of the recipe is not valid
     */
    public RecipeJPAToDomainDTO toDomain(RecipeJPA recipeJPA) throws InvalidNameException {
        RecipeID recipeID = new RecipeID(recipeJPA.getId());
        RecipeTitle recipeTitle = new RecipeTitle(recipeJPA.getTitle());
        MealType mealType = MealType.valueOf(recipeJPA.getMealType());
        int numberOfPerson = Integer.parseInt(recipeJPA.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(recipeJPA.getDifficultyLevel());
        List<IngredientJPA> ingredientJPAList = recipeJPA.getIngredientList();
        List<Ingredient> ingredientList = IngredientAssembler.toDomain(ingredientJPAList);
        String preparationSteps = recipeJPA.getPreparationSteps();

        return new RecipeJPAToDomainDTO(recipeID, recipeTitle, mealType, numberOfPerson, difficultyLevel, ingredientList, preparationSteps);
    }

    /**
     * Method that receives a domain object and transforms it into a data model object.
     *
     * @param recipe - domain object
     * @return the data model object
     */
    public RecipeJPA toData(Recipe recipe) {
        String recipeID = recipe.getId().toString();
        String recipeTitle = recipe.getTitle().toString();
        String mealType = recipe.getMealType().name();
        String numberOfPerson = Integer.toString(recipe.getNumberOfPerson());
        String difficultyLevel = recipe.getDifficultyLevel().name();
        String preparationSteps = recipe.getPreparationSteps();
        RecipeJPA recipeJPA = new RecipeJPA(recipeID, recipeTitle, mealType, numberOfPerson, difficultyLevel, preparationSteps);

        List<Ingredient> ingredientList = recipe.getIngredientList();
        for (Ingredient ingredient : ingredientList) {
            recipeJPA.addIngredientJPA(new IngredientJPA(ingredient.getId().toString(), ingredient.getName(), ingredient.getMeasureUnity().toString(), recipeJPA));
        }
        return recipeJPA;
    }

}
