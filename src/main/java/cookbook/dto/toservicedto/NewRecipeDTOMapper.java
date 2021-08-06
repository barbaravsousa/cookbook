package cookbook.dto.toservicedto;

import cookbook.dto.indto.NewRecipeInDTO;

import java.util.List;

public class NewRecipeDTOMapper {

    private NewRecipeDTOMapper(){}

    public static NewRecipeDTO toDTO(NewRecipeInDTO inDTO){
        String title = inDTO.getTitle();
        String mealType = inDTO.getMealType();
        String numberOfPerson = inDTO.getNumberOfPerson();
        String difficultyLevel = inDTO.getDifficultyLevel();
        //List<String> ingredientsList = inDTO.getIngredientsList();
        List<String> preparationStepsList = inDTO.getPreparationStepsList();

        return new NewRecipeDTO(title,mealType,numberOfPerson,difficultyLevel,preparationStepsList);



    }
}
