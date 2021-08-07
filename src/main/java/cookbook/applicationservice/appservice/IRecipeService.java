package cookbook.applicationservice.appservice;

import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidNameException;

public interface IRecipeService {

    NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe) throws InvalidNameException;
}
