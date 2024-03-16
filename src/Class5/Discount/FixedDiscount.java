package Class5.Discount;

import java.util.Objects;

public class FixedDiscount extends Discount {
    private int num;
    @Override
    public Double getFinalValue(Double initialValue) {
        return (initialValue * this.getValue()) / 100;
    }

    @Override
    public Double getFinalValue(Double initialValue, Integer quantity) {
        return ((initialValue * quantity) * this.getValue() / 100);
    }

    @Override //In this case the reference of this class in the "main method" will print THIS "toString()" and the father class method (super)
    public String toString() {
        return super.toString() + "FixedDiscount{" +
                "num=" + num +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FixedDiscount that = (FixedDiscount) o;
        return num == that.num;
    }

    @Override
    public int hashCode() {
        return Objects.hash(num);
    }
}
