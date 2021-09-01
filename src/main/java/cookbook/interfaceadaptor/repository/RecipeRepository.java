package cookbook.interfaceadaptor.repository;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.datamodel.RecipeJPA;
import cookbook.datamodel.assembler.RecipeAssembler;
import cookbook.domain.Recipe;
import cookbook.domain.id.IngredientID;
import cookbook.domain.id.RecipeID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeRepository implements IRecipeRepository {

    @Autowired
    RecipeJPARepository repository;
    @Autowired
    RecipeAssembler assembler;


    /**
     * Transforms a Recipe into RecipeJPA and adds them to the repository.
     *
     * @param recipe domain object
     */
    public void save(Recipe recipe) {
        RecipeJPA recipeJPA = assembler.toData(recipe);
        this.repository.save(recipeJPA);
    }

    /**
     * Checks if a certain recipe ID exists in the database.
     *
     * @param recipeID
     * @return true if the ID already exists
     */
    public boolean existsByID(RecipeID recipeID) {
        return this.repository.existsById(recipeID.toString());
    }

    /**
     * Checks if a certain Ingredient ID exists in the database.
     *
     * @param id
     * @return true if the ID exists
     */
    public boolean existsByID(IngredientID id) {
        return this.repository.existsById(id.toString());
    }

    /**
     * Deletes all data from the repository.
     */
    public void deleteAll() {
        this.repository.deleteAll();
    }

}
