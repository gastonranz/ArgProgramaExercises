package Class5;

import java.util.Objects;

public class ItemCarrito {
    private Product product;
    private Integer quantity;

    public ItemCarrito(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public ItemCarrito() {}

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getProductPrice() {
        return this.product.getPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemCarrito that = (ItemCarrito) o;
        return Objects.equals(product, that.product) && Objects.equals(quantity, that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
