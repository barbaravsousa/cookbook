package cookbook.datamodel.assembler;


import cookbook.datamodel.IngredientJPA;
import cookbook.datamodel.RecipeJPA;
import cookbook.domain.Ingredient;
import cookbook.domain.MeasureUnity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class IngredientAssembler {

    /**
     * @param ingredient
     * @param recipeJPA
     * @return
     */
    public static IngredientJPA toData(Ingredient ingredient, RecipeJPA recipeJPA) {
        String name = ingredient.getName();
        String measureUnit = ingredient.getMeasureUnity().toString();

        return new IngredientJPA(name, measureUnit, recipeJPA);
    }

    /**
     *
     * @param ingredientJPA
     * @return
     */
    public static Ingredient toDomain(IngredientJPA ingredientJPA) {
        String name = ingredientJPA.getName();
        String unit = ingredientJPA.getMeasureUnit();


    }


    /**
     *
     * @param ingredientJPAList
     * @return
     */
    public static List<Ingredient> toDomain(List<IngredientJPA> ingredientJPAList) {
        List<Ingredient>  ingredientList = new ArrayList<>();
        for(IngredientJPA ingredientJPA:ingredientJPAList){
            ingredientList.add(toDomain(ingredientJPA));
        }
        return ingredientList;
    }

}
