package Class5;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product prod1 = new Product("WhiteBoard", 90.0, "sjw28a928a");
        Product prod2 = new Product("BackPack", 40.0, "laksjdf2234klj2k3");
        Product prod3 = new Product("SuitCase", 120.0, "234k2l2l34kl234");

        ItemCarrito item1 = new ItemCarrito(prod1, 1);
        ItemCarrito item2 = new ItemCarrito(prod2, 3);
        ItemCarrito item3 = new ItemCarrito(prod3, 12);

        List<ItemCarrito> itemList1 = new ArrayList<>();
        itemList1.add(item1);
        itemList1.add(item2);
        itemList1.add(item3);

        Carrito carrito1 = new Carrito(itemList1);
        carrito1.getPrice();
        System.out.println("-----");

        Double discount = 20d;

        Discount.getDiscount(carrito1, discount);

        Product prod4 = new Product("WhiteBoard", 100.0, "sjw28a928a");
        Product prod5 = new Product("BackPack", 450.0, "laksjdf2234klj2k3");

        ItemCarrito item4 = new ItemCarrito(prod4, 1);
        ItemCarrito item5 = new ItemCarrito(prod5, 3);

        List<ItemCarrito> itemList2 = new ArrayList<>();
        itemList2.add(item4);
        itemList2.add(item5);

        Carrito carrito2 = new Carrito(itemList2);
        carrito2.getPrice();
        System.out.println("-----");

        Discount.getDiscount(carrito2, 30d);
    }
}
