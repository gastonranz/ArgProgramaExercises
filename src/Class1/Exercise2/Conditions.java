package Class1.Exercise2;

public class Conditions {
    private static final Double MONTH_INCOME = 489083d;
    private static final Integer CARS = 3;
    private static final Integer OLD_CAR_LIMIT = 5;
    private static final Integer HOUSES = 3;
    private static final boolean HAS_A_BOAT = false;
    private static final boolean HAS_AIRCRAFT = false;
    private static final boolean HAS_CORP_ASSETS = false;

    public static void isHighIncome(Person person) {
        boolean isHighIncome = person.getMonthIncome() >= 489083d || (person.getCars() >= 3 &&
                person.getOldCarLimit() < 5) || person.getHouses() >= 3 || person.isHasABoat() ||
                person.isHasAircraft() || person.isHasCorpAssets();
        if(isHighIncome) {
            System.out.println(person.getName() + " has a high income.");
        } else {
            System.out.println(person.getName() + " it has a normal status");
        }
    }
}
