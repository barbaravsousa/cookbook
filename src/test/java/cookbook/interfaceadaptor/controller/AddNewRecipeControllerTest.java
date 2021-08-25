package cookbook.interfaceadaptor.controller;

import cookbook.dto.indto.NewRecipeInDTO;
import cookbook.dto.toservicedto.NewRecipeDTO;
import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AddNewRecipeControllerTest {

    @Autowired
    AddNewRecipeController controller;


    @Test
    void addNewRecipeSuccess() throws InvalidNameException {

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Massa 2g");
        NewRecipeInDTO newRecipeDTO = new NewRecipeInDTO("Massa", "LUNCH", "2", "BEGGINNER", ingredients, "Cozer a massa");

        ResponseEntity<Object> result = controller.addNewRecipe(newRecipeDTO);
        int expected = 200;

        assertEquals(expected,result);
    }

    @Test
    void addNewRecipeFailure() throws InvalidNameException {

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Massa 2g");
        NewRecipeInDTO newRecipeDTO = new NewRecipeInDTO("Ma87a", "LUNCH", "2", "BEGGINNER", ingredients, "Cozer a massa");

        ResponseEntity<Object> result = controller.addNewRecipe(newRecipeDTO);
        int expected = 400;

        assertEquals(expected,result);
    }

}