package cookbook.dto.toservicedto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@Getter
public class NewRecipeDTO {

    private String title;
    private String mealType;
    private String numberOfPerson;
    private String difficultyLevel;
    private List<String> ingredientsList;
    private String preparationSteps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewRecipeDTO that = (NewRecipeDTO) o;
        return Objects.equals(title, that.title) && Objects.equals(mealType, that.mealType) && Objects.equals(numberOfPerson, that.numberOfPerson) && Objects.equals(difficultyLevel, that.difficultyLevel) && Objects.equals(ingredientsList, that.ingredientsList) && Objects.equals(preparationSteps, that.preparationSteps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, mealType, numberOfPerson, difficultyLevel, ingredientsList, preparationSteps);
    }
}
