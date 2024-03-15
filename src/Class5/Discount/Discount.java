package Class5.Discount;

import Class5.Carrito;
import Class5.ItemCarrito;

import java.util.List;

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
