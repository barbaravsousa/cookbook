package cookbook.domain.id;

import java.util.Objects;

public class IngredientID {

    private final String id;

    public IngredientID(String id){
        Objects.requireNonNull(id);
        this.id=id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IngredientID id1 = (IngredientID) o;
        return Objects.equals(id, id1.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return id;
    }
}
