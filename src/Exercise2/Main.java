package Exercise2;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("Kim", "Street 10", "29", "3517880970",
                489083d, 2, 4, 10, true, false, false);
        Conditions.isHighIncome(person);
    }
}
