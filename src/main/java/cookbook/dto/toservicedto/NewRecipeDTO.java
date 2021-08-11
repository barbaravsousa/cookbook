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
    private List<String> preparationStepsList;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NewRecipeDTO that = (NewRecipeDTO) o;
        return Objects.equals(title, that.title) && Objects.equals(mealType, that.mealType) && Objects.equals(numberOfPerson, that.numberOfPerson) && Objects.equals(difficultyLevel, that.difficultyLevel) && Objects.equals(ingredientsList, that.ingredientsList) && Objects.equals(preparationStepsList, that.preparationStepsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, mealType, numberOfPerson, difficultyLevel, ingredientsList, preparationStepsList);
    }
}
