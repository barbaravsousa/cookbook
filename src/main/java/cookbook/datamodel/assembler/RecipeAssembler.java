package cookbook.datamodel.assembler;

import cookbook.datamodel.IngredientJPA;
import cookbook.datamodel.RecipeJPA;
import cookbook.domain.*;
import cookbook.dto.todomaindto.RecipeJPAToDomainDTO;
import cookbook.exception.InvalidNameException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RecipeAssembler {

    /**
     * @param recipeJPA
     * @return
     * @throws InvalidNameException
     */
    public RecipeJPAToDomainDTO toDomain(RecipeJPA recipeJPA) throws InvalidNameException {
        RecipeTitle recipeTitle = new RecipeTitle(recipeJPA.getTitle());
        MealType mealType = MealType.valueOf(recipeJPA.getMealType());
        int numberOfPerson = Integer.parseInt(recipeJPA.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(recipeJPA.getDifficultyLevel());
        List<IngredientJPA> ingredientJPAList = recipeJPA.getIngredientList();
        List<Ingredient> ingredientList = IngredientAssembler.toDomain(ingredientJPAList);
        String preparationSteps = recipeJPA.getPreparationSteps();

        return new RecipeJPAToDomainDTO(recipeTitle, mealType, numberOfPerson, difficultyLevel, ingredientList, preparationSteps);
    }

    public RecipeJPA toData(Recipe recipe) {
        String recipeTitle = recipe.getTitle().toString();
        String mealType = recipe.getMealType().name();
        String numberOfPerson = Integer.toString(recipe.getNumberOfPerson());
        String difficultyLevel = recipe.getDifficultyLevel().name();
        List<IngredientJPA> ingredientJPAList = IngredientAssembler.toData(recipe.getIngredientList());
        String preparationSteps = recipe.getPreparationSteps();
        return new RecipeJPA(recipeTitle,mealType,numberOfPerson,difficultyLevel,ingredientJPAList,preparationSteps);
    }

}
