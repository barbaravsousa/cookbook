package cookbook.domain;

import cookbook.domain.id.RecipeID;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class Recipe {
    private final RecipeID id;
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
        return numberOfPerson == recipe.numberOfPerson && Objects.equals(id, recipe.id) && Objects.equals(title, recipe.title) && mealType == recipe.mealType && difficultyLevel == recipe.difficultyLevel && Objects.equals(ingredientList, recipe.ingredientList) && Objects.equals(preparationSteps, recipe.preparationSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, mealType, numberOfPerson, difficultyLevel, ingredientList, preparationSteps);
    }
}
