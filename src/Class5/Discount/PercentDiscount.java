package Class5.Discount;

public class PercentDiscount extends Discount {
    @Override
    public Double getFinalValue(Double initialValue) {
        return (initialValue) - ((initialValue * this.getValue()) / 100);
    }

    @Override
    public Double getFinalValue(Double initialValue, Integer quantity) {
        return (initialValue * quantity) - ((initialValue * this.getValue()) / 100);
    }
}
