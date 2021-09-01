package cookbook.applicationservice.irepository;

import cookbook.domain.Recipe;
import cookbook.domain.id.IngredientID;
import cookbook.domain.id.RecipeID;

public interface IRecipeRepository {

    void save(Recipe recipe);
    boolean existsByID(RecipeID recipeID);
    boolean existsByID(IngredientID id);
    void deleteAll();

}
