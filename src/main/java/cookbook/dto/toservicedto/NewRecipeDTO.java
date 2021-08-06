package cookbook.dto.toservicedto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NewRecipeDTO {

    private String title;
    private String mealType;
    private String numberOfPerson;
    private String difficultyLevel;
    //private String ingredient;
    //private List<String> ingredientsList;
    private List<String> preparationStepsList;

}
