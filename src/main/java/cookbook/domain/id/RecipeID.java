package cookbook.domain.id;


import java.util.Objects;


public class RecipeID {

    private final String id;


    public RecipeID(String id){
        Objects.requireNonNull(id);
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecipeID recipeID = (RecipeID) o;
        return Objects.equals(id, recipeID.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.id.toString();
    }
}
