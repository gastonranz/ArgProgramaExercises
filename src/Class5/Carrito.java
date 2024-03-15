package Class5;

import java.util.List;
import java.util.Objects;

public class Carrito {
    private List<ItemCarrito> itemsCarrito;
    private int itemNumber;

    public Carrito(List<ItemCarrito> itemsCarrito) {
        this.itemsCarrito = itemsCarrito;
        this.itemNumber = 0;
    }

    public Carrito() {
        this.itemNumber = 0;
    }

    public List<ItemCarrito> getItemsCarrito() {
        return itemsCarrito;
    }

    public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
        this.itemsCarrito = itemsCarrito;
    }

    public void getPrice() {
        Double totalPrice = 0d;
        boolean value = false;

        for(ItemCarrito item : this.itemsCarrito) {
            if(this.itemNumber != 0 && !value) {
                this.itemNumber = 0;
                value = true;
            } else if(this.itemNumber == 0 && !value) {
                value = true;
            }
            this.itemNumber++;
            totalPrice += item.getProductPrice();
            System.out.println("Item " + this.itemNumber + ": " + item.getProduct().getName());
        }

        if(itemsCarrito.size() < 4) System.out.println("Total price: $" + totalPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carrito carrito = (Carrito) o;
        return Objects.equals(itemsCarrito, carrito.itemsCarrito);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsCarrito);
    }

    @Override
    public String toString() {
        return "Carrito{" +
                "itemsCarrito=" + itemsCarrito +
                '}';
    }
}