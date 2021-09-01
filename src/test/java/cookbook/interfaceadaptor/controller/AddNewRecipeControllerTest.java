package cookbook.interfaceadaptor.controller;

import cookbook.dto.indto.NewRecipeInDTO;
import cookbook.exception.InvalidNameException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AddNewRecipeControllerTest {

    @Autowired
    AddNewRecipeController controller;


    @Test
    void addNewRecipeSuccess() throws InvalidNameException {

        List<String> ingredients = new ArrayList<>();
        ingredients.add("massa 2g");
        NewRecipeInDTO newRecipeDTO = new NewRecipeInDTO("massa", "MEAL", "2", "BEGINNER", ingredients, "Cozer a massa");

        ResponseEntity<Object> result = controller.addNewRecipe(newRecipeDTO);
        int expected = 201;

        assertEquals(expected,result.getStatusCodeValue());
    }

    @Test
    void addNewRecipeFailure() throws InvalidNameException {

        List<String> ingredients = new ArrayList<>();
        ingredients.add("Massa 2g");
        NewRecipeInDTO newRecipeDTO = new NewRecipeInDTO("Ma87a", "MEAL", "2", "BEGGINNER", ingredients, "Cozer a massa");

        ResponseEntity<Object> result = controller.addNewRecipe(newRecipeDTO);
        int expected = 400;

        assertEquals(expected,result.getStatusCodeValue());
    }

}