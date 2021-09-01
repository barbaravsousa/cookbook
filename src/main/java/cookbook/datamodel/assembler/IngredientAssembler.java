package cookbook.datamodel.assembler;


import cookbook.datamodel.IngredientJPA;
import cookbook.datamodel.RecipeJPA;
import cookbook.domain.Ingredient;
import cookbook.domain.MeasureUnity;
import cookbook.domain.id.IngredientID;
import cookbook.util.Utils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientAssembler {

    /**
     * Method that receives a domain object and transforms it into a data model object.
     *
     * @param ingredient, domain object
     * @return an IngredientJPA object
     */
    public static IngredientJPA toData(Ingredient ingredient, RecipeJPA recipeJPA) {
        String id = ingredient.getId().toString();
        String name = ingredient.getName();
        String measureUnit = ingredient.getMeasureUnity().toString();

        return new IngredientJPA(id,name,measureUnit,recipeJPA);
    }

    /**
     * Method that transforms a data model object into a domain object.
     *
     * @param ingredientJPA, data model object
     * @return an Ingredient, domain object
     */
    public static Ingredient toDomain(IngredientJPA ingredientJPA) {
        IngredientID id = new IngredientID(ingredientJPA.getId());
        String name = ingredientJPA.getName();
        String unit = ingredientJPA.getMeasureUnit();
        MeasureUnity measureUnity = Utils.splitMeasureUnity(unit);
        return new Ingredient(id,name, measureUnity);
    }


    /**
     * Method that receives a list with data model objects and transforms them into domain objects and adds them to a list.
     *
     * @param ingredientJPAList, list with data model objects
     * @return a list with domain objects
     */
    public static List<Ingredient> toDomain(List<IngredientJPA> ingredientJPAList){
        List<Ingredient> ingredientList = new ArrayList<>();
        for (IngredientJPA ingredientJPA : ingredientJPAList) {
            ingredientList.add(toDomain(ingredientJPA));
        }
        return ingredientList;
    }

    /**
     * Method that receives a list with domain objects and transforms them into data model objects.
     *
     * @param ingredientList, object domain list
     * @return a list with data model objects
     */
    public static List<IngredientJPA> toData(List<Ingredient> ingredientList, RecipeJPA recipeJPA) {
        List<IngredientJPA> ingredientJPAList = new ArrayList<>();
        for (Ingredient ingredient : ingredientList) {
            ingredientJPAList.add(toData(ingredient,recipeJPA));
        }
        return ingredientJPAList;
    }

}
