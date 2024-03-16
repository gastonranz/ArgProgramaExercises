package Class5and7;

import java.util.Objects;

public class Product {
    private String name;
    private Double price;
    private String code;

    public Product(String name, Double price, String code) {
        this.name = name;
        this.price = price;
        this.code = code;
    }

    public Product() {}

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(code, product.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, code);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", code='" + code + '\'' +
                '}';
    }
}
