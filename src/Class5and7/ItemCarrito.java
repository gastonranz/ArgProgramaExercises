package Class5and7;

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
        if (this == o) return true; //same reference
        if (o == null || getClass() != o.getClass()) return false; //Object reference is null or ItemCarrito is another class than Object
        ItemCarrito that = (ItemCarrito) o; //Casting before comparing attributes
        return Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product); //Return the hashcode of the ATTRIBUTE (NOT THE CLASS HASHCODE) I selected in this method;
    }

    @Override
    public String toString() {
        return "ItemCarrito{" +
                "product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}
