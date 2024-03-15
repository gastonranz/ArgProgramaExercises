package Class5.Discount;

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

    @Override
    public String toString() {
        return super.toString() + "FixedDiscount{" +
                "num=" + num +
                '}';
    }
}
