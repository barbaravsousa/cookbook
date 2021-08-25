package cookbook.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Recipe")

public class RecipeJPA {

    @Id
    Integer id;
    @Getter
    String title;
    @Getter
    String mealType;
    @Getter
    String numberOfPerson;
    @Getter
    String difficultyLevel;
    @Getter
    @OneToMany(mappedBy = "recipeJPA", cascade = CascadeType.ALL)
    List<IngredientJPA> ingredientList;
    @Getter
    String preparationSteps;

    public RecipeJPA(Integer id, String title, String mealType, String numberOfPerson, String difficultyLevel, List<IngredientJPA> ingredientList, String preparationSteps) {
        this.id = id;
        this.title = title;
        this.mealType = mealType;
        this.numberOfPerson = numberOfPerson;
        this.difficultyLevel = difficultyLevel;
        this.ingredientList = ingredientList;
        this.preparationSteps = preparationSteps;
    }

    public RecipeJPA(String title, String mealType, String numberOfPerson, String difficultyLevel, List<IngredientJPA> ingredientList, String preparationSteps) {
        this.title = title;
        this.mealType = mealType;
        this.numberOfPerson = numberOfPerson;
        this.difficultyLevel = difficultyLevel;
        this.ingredientList = ingredientList;
        this.preparationSteps = preparationSteps;
    }
}
