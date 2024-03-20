package Class5and7;

public class Main2 {
    public static void main(String[] args) {
        Auto auto = new Auto();
        Auto auto2 = new Auto();
        auto.setName("Dogde");
        auto2.setName("Dogde");

        System.out.println(auto.equals(auto2));
    }
}
