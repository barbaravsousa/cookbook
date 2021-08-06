package cookbook.domain;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Recipe {
    private String title;
    private MealType mealType;
    private int numberOfPerson;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredientList;
    private List<String> preparationStepsList;

}
