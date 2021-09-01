package cookbook.datamodel;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "recipe")
@NoArgsConstructor
public class RecipeJPA {

    @Id
    @Getter
    String id;
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

    public RecipeJPA(String id, String title, String mealType, String numberOfPerson, String difficultyLevel, String preparationSteps) {
        this.id = id;
        this.title = title;
        this.mealType = mealType;
        this.numberOfPerson = numberOfPerson;
        this.difficultyLevel = difficultyLevel;
        this.ingredientList = new ArrayList<>();
        this.preparationSteps = preparationSteps;
    }


    /**
     * Method that adds an IngredientJPA to the list of ingredients jpa.
     *
     * @param ingredientJPA
     */
    public void addIngredientJPA(IngredientJPA ingredientJPA) {
        this.ingredientList.add(ingredientJPA);


    }


}
