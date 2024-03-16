package Class5and7.Discount;

public class DescuentoPorcentajeConTope extends Discount {
    @Override
    public Double getFinalValue(Double initialValue) {
        if(this.getValue() < 50d) {
            return initialValue - ((initialValue * this.getValue()) / 100);
        } else {
            System.out.println("The value is over the top");
            return null;
        }
    }

    @Override
    public Double getFinalValue(Double initialValue, Integer quantity) {
        if(this.getValue() < 50d) {
            return (initialValue * quantity) - (((initialValue * quantity) * this.getValue()) / 100);
        } else {
            System.out.println("The value is over the top");
            return null;
        }
    }
}
