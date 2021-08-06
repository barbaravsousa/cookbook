package cookbook.applicationservice.appservice;

import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;

public interface IRecipeService {

    NewRecipeOutDTO createNewRecipe(NewRecipeDTO newRecipe);
}
