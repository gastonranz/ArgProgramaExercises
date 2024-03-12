package Class5;

import java.util.List;

public class Discount {
    public static void getDiscount(List<ItemCarrito> itemsCarrito, Double discount) {
        Double itemDiscount;
        Double totalDiscount = 0d;
        Double totalValues = 0d;
        for(ItemCarrito item : itemsCarrito) {
            itemDiscount = (item.getProductPrice() * discount) / 100;
            totalDiscount += item.getProductPrice() - (item.getProductPrice() * discount) / 100;
            totalValues += item.getProductPrice();

            System.out.println("Item " + item.getProduct().getName() + " - Value: $" + item.getProductPrice() +
                    " - Discount: $" + itemDiscount);

            System.out.println("\n-------------------\nTotal value: $" + totalValues + " - Total discount: $" +
                    totalDiscount);
        }
    }
}
