package cookbook.domain;

import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
public class MeasureUnity {
    private int amount;
    private String unit;

    @Override
    public String toString() {
        return amount + unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MeasureUnity that = (MeasureUnity) o;
        return amount == that.amount && Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, unit);
    }
}
