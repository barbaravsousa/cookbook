package cookbook.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "ingredients")
@NoArgsConstructor
@AllArgsConstructor
public class IngredientJPA {

    @Id
    @Getter
    String id;
    @Getter
    String name;
    @Getter
    String measureUnit;
    @Getter
    @ManyToOne
    @JoinColumn(name = "recipeID")
    RecipeJPA recipeJPA;


}
