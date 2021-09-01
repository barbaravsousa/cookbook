package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.id.RecipeID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class RecipeIDGenerator {

    @Autowired
    IRecipeRepository repository;

    /**
     * Generates a RecipeID and returns it.
     *
     * @return the generated ID
     */
    public RecipeID generates() {
        RecipeID recipeID;
        do {
            recipeID = new RecipeID(UUID.randomUUID().toString());
        } while (repository.existsByID(recipeID));
        return recipeID;
    }
}
