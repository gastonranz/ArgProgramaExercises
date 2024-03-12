package Class5;

import java.util.List;

public class Discount {
    public static void getDiscount(Carrito carrito, Double discount) {
        List<ItemCarrito> itemsCarrito = carrito.getItemsCarrito();
        Double itemDiscount;
        Double totalPriceWithDiscount = 0d;
        Double totalValues = 0d;
        Double totalDiscount = 0d;

        for(ItemCarrito item : itemsCarrito) {
            itemDiscount = Discount.getDiscountValue(item, discount);
            totalPriceWithDiscount += item.getProductPrice() - Discount.getDiscountValue(item, discount);;
            totalValues += item.getProductPrice();
            totalDiscount += Discount.getDiscountValue(item, discount);;

            System.out.println("Item " + item.getProduct().getName() + " - Value: $" + item.getProductPrice() +
                    " - Discount: $" + itemDiscount);
        }

        System.out.println("-------------------\nTotal value: $" + totalValues + " - Total discount: $" +
                totalDiscount + "\nFinal price: $" + totalPriceWithDiscount);
    }

    private static Double getDiscountValue(ItemCarrito item, Double discount) {
        return (item.getProductPrice() * discount) / 100;
    }
}
