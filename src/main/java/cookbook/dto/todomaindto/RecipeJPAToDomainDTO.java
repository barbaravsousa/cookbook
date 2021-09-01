package cookbook.dto.todomaindto;

import cookbook.domain.*;
import cookbook.domain.id.RecipeID;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@Getter
@AllArgsConstructor
public class RecipeJPAToDomainDTO {

    private RecipeID recipeID;
    private RecipeTitle title;
    private MealType mealType;
    private int numberOfPerson;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredientList;
    private String preparationSteps;

}
