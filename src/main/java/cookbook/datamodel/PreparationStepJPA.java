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
@Table(name="PreparationSteps")
public class PreparationStepJPA {

    @Id
    Integer id;
    @Getter
    String step;
    @ManyToOne
    RecipeJPA recipeJPA;


}
