package Class5;

public class Product {
    private String item1;
    private String item2;
    private String item3;

    public Product(String item1, String item2, String item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public Product() {};

    public String getItem1() {
        return this.item1;
    }

    public void setItem1(String item1) {
        this.item1 = item1;
    }

    public String getItem2() {
        return this.item2;
    }

    public void setItem2(String item2) {
        this.item2 = item2;
    }

    public String getItem3() {
        return this.item3;
    }

    public void setItem3(String item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return "Product{" +
                "item1='" + item1 + '\'' +
                ", item2='" + item2 + '\'' +
                ", item3='" + item3 + '\'' +
                '}';
    }
}
