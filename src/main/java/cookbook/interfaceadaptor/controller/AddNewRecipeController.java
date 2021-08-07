package cookbook.interfaceadaptor.controller;

import cookbook.applicationservice.appservice.IRecipeService;
import cookbook.dto.indto.NewRecipeInDTO;
import cookbook.dto.outdto.NewRecipeOutDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.dto.toservicedto.NewRecipeDTOMapper;
import cookbook.exception.InvalidNameException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001", "http://localhost:3002"}, maxAge = 3600)
public class AddNewRecipeController {

    @Autowired
    private final IRecipeService recipeService;

    @PostMapping("/recipes")
    public ResponseEntity<Object> addNewRecipe(@RequestBody NewRecipeInDTO info) throws InvalidNameException {
        try {
            NewRecipeDTO newRecipeDTO = NewRecipeDTOMapper.toDTO(info);
            NewRecipeOutDTO newRecipe = this.recipeService.createNewRecipe(newRecipeDTO);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        }catch(InvalidNameException exception){
            String errorMessage = exception.getMessage();
            return new ResponseEntity<>(errorMessage,HttpStatus.BAD_REQUEST);
        }

    }

}
