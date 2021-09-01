package cookbook.domain;
import cookbook.domain.id.IngredientID;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Ingredient {
    private IngredientID id;
    private String name;
    private MeasureUnity measureUnity;

    /**
     * Constructor.
     *
     * @param id of the ingredient
     * @param name of the ingredient
     * @param measureUnity quantity of the ingredient
     */
    public Ingredient(IngredientID id,String name, MeasureUnity measureUnity){
        this.id = id;
        this.name=name;
        this.measureUnity=measureUnity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(measureUnity, that.measureUnity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, measureUnity);
    }
}

