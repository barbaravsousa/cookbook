package cookbook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class Recipe {
    @Getter
    private RecipeTitle title;
    private MealType mealType;
    private int numberOfPerson;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredientList;
    private List<String> preparationStepsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return numberOfPerson == recipe.numberOfPerson && Objects.equals(title, recipe.title) && mealType == recipe.mealType && difficultyLevel == recipe.difficultyLevel && Objects.equals(ingredientList, recipe.ingredientList) && Objects.equals(preparationStepsList, recipe.preparationStepsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, mealType, numberOfPerson, difficultyLevel, ingredientList, preparationStepsList);
    }
}
