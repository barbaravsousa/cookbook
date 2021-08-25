package cookbook.domain;
import cookbook.exception.InvalidNameException;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Ingredient {
    private String name;
    private MeasureUnity measureUnity;

    /**
     * Constructor.
     *
     * @param name of the ingredient
     * @param measureUnity quantity of the ingredient
     * @throws InvalidNameException in case the name of the ingredient is invalid
     */
    public Ingredient(String name, MeasureUnity measureUnity) throws InvalidNameException{
        isIngredientNameValid(name);
        this.name=name;
        this.measureUnity=measureUnity;
    }
    /**
     * Method that checks if the ingredient name is valid and only has letters.
     *
     * @param ingredientName
     * @throws InvalidNameException if the title isn't valid
     */
    private void isIngredientNameValid(String ingredientName) throws InvalidNameException {
        if (ingredientName == null || ingredientName.trim().length() == 0 || !ingredientName.matches("[A-zÀ-ÿ\\s']*")) {
            throw new InvalidNameException("This ingredient doesn't seem correct. Try again!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name) && Objects.equals(measureUnity, that.measureUnity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, measureUnity);
    }


}

