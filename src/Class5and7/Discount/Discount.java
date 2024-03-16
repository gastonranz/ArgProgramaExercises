package Class5and7.Discount;

public abstract class Discount {
    private Double value;

    public Double getValue() {
        return this.value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public abstract Double getFinalValue(Double initialValue);
    public abstract Double getFinalValue(Double initialValue, Integer quantity);
}
