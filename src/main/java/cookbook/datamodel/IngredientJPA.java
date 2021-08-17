package cookbook.datamodel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Ingredients")
public class IngredientJPA {

    @Id
    Integer id;
    @Getter
    String name;
    @Getter
    String measureUnit;
    @ManyToOne
    RecipeJPA recipeJPA;


}
