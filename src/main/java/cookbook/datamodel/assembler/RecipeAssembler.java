package cookbook.datamodel.assembler;

import cookbook.datamodel.RecipeJPA;
import cookbook.domain.DifficultyLevel;
import cookbook.domain.Ingredient;
import cookbook.domain.MealType;
import cookbook.domain.RecipeTitle;
import cookbook.dto.todomaindto.RecipeJPAToDomainDTO;
import cookbook.exception.InvalidNameException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeAssembler {

    public RecipeJPAToDomainDTO toDomain(RecipeJPA recipeJPA) throws InvalidNameException {
        RecipeTitle recipeTitle= new RecipeTitle(recipeJPA.getTitle());
        MealType mealType = MealType.valueOf(recipeJPA.getMealType());
        int numberOfPerson = Integer.parseInt(recipeJPA.getNumberOfPerson());
        DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(recipeJPA.getDifficultyLevel());
        List<String> ingredientsList = recipeJPA.getIngredientsList();
        List<Ingredient> ingredientListParsed = splitListOfIngredients(ingredientsList);
        List<String> preparationStepsList = recipeJPA.getPreparationStepsList();


    }

}
