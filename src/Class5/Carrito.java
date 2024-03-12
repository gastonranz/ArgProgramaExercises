package Class5;

import java.util.List;
import java.util.Objects;

public class Carrito {
    private List<ItemCarrito> itemsCarrito;

    public Carrito(List<ItemCarrito> itemsCarrito) {
        this.itemsCarrito = itemsCarrito;
    }

    public Carrito() {}

    public List<ItemCarrito> getItemsCarrito() {
        return itemsCarrito;
    }

    public void setItemsCarrito(List<ItemCarrito> itemsCarrito) {
        this.itemsCarrito = itemsCarrito;
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