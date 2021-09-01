package cookbook.applicationservice.appservice;

import cookbook.applicationservice.irepository.IRecipeRepository;
import cookbook.domain.id.IngredientID;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class IngredientIDGenerator {

    @Autowired
    IRecipeRepository repository;

    /**
     * Generates an IngredientID and returns it.
     *
     * @return the generated ID
     */
    public IngredientID generates() {
        IngredientID id;
        do {
            id = new IngredientID(UUID.randomUUID().toString());
        } while (repository.existsByID(id));
        return id;
    }
}
