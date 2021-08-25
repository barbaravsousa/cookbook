package cookbook.dto.todomaindto;


import cookbook.domain.DifficultyLevel;
import cookbook.domain.Ingredient;
import cookbook.domain.MealType;
import cookbook.domain.RecipeTitle;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.List;

@Getter
@AllArgsConstructor
public class RecipeJPAToDomainDTO {

    private RecipeTitle title;
    private MealType mealType;
    private int numberOfPerson;
    private DifficultyLevel difficultyLevel;
    private List<Ingredient> ingredientList;
    private String preparationSteps;

}
