package cookbook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
public class Recipe {
    @Getter
    private RecipeTitle title;
    private MealType mealType;
    private int numberOfPerson;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredientList;
    private List<String> preparationStepsList;

}
