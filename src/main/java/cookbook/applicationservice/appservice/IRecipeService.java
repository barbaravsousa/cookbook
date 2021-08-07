package cookbook.applicationservice.appservice;

import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidRecipeTitleException;

public interface IRecipeService {

    NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe) throws InvalidRecipeTitleException;
}
