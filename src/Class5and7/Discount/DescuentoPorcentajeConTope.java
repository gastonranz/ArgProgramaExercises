package Class5and7.Discount;

public class DescuentoPorcentajeConTope extends Discount {
    @Override
    public Double getFinalValue(Double initialValue) {
        double percentValue = 50d;
        if(this.getValue() < percentValue) {
            return initialValue - ((initialValue * this.getValue()) / 100); //Individual product value
        } else {
            System.out.println("The percent value is over the top, it must be smaller than " + percentValue+ "%");
            return null;
        }
    }

    @Override
    public Double getFinalValue(Double initialValue, Integer quantity) {
        double percentValue = 50d;
        if(this.getValue() < percentValue) {
            return (initialValue * quantity) - (((initialValue * quantity) * this.getValue()) / 100);
        } else {
            System.out.println("The percent value is over the top, it must be smaller than " + percentValue + "%");
            return null;
        }
    }
}
