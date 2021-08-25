package cookbook.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
public class Recipe {
    @Getter
    private final RecipeTitle title;
    private final MealType mealType;
    private final int numberOfPerson;
    private final DifficultyLevel difficultyLevel;
    private final List<Ingredient> ingredientList;
    private final String preparationSteps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return numberOfPerson == recipe.numberOfPerson && Objects.equals(title, recipe.title) && mealType == recipe.mealType && difficultyLevel == recipe.difficultyLevel && Objects.equals(ingredientList, recipe.ingredientList) && Objects.equals(preparationSteps, recipe.preparationSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, mealType, numberOfPerson, difficultyLevel, ingredientList, preparationSteps);
    }
}
