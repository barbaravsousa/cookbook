package cookbook.dto.indto;
import cookbook.domain.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class NewRecipeInDTO {


    private String title;
    private String mealType;
    private String numberOfPerson;
    private String difficultyLevel;
    private List<String> ingredientsList;
    private String preparationSteps;


}
