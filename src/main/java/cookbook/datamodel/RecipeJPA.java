package cookbook.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Recipe")
@AllArgsConstructor
@NoArgsConstructor
public class RecipeJPA {

    @Id
    Integer id;
    @Getter
    String title;
    @Getter
    String mealType;
    @Getter
    Integer numberOfPerson;
    @Getter
    String difficultyLevel;
    @Getter
    @OneToMany(mappedBy = "recipeJPA", cascade = CascadeType.ALL)
    List<IngredientJPA> ingredientList;
    @Getter
    @OneToMany(mappedBy = "recipeJPA", cascade = CascadeType.ALL)
    List<PreparationStepJPA> preparationList;

}
