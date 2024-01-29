package Exercise2;

import java.util.Objects;

public class Person {
    private String name;
    private String address;
    private String age;
    private String phoneNumber;
    private Double monthIncome;
    private Integer cars;
    private Integer oldCarLimit;
    private Integer houses;
    private boolean hasABoat;
    private boolean hasAircraft;
    private boolean hasCorpAssets;

    public Person(String name, String address, String age, String phoneNumber, Double monthIncome, Integer cars,
                  Integer oldCarLimit, Integer houses, boolean hasABoat, boolean hasAircraft, boolean hasCorpAssets) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.monthIncome = monthIncome;
        this.cars = cars;
        this.oldCarLimit = oldCarLimit;
        this.houses = houses;
        this.hasABoat = hasABoat;
        this.hasAircraft = hasAircraft;
        this.hasCorpAssets = hasCorpAssets;
    }

    public Person(String name, Double monthIncome, Integer cars, Integer oldCarLimit, Integer houses, boolean hasABoat,
                  boolean hasAircraft, boolean hasCorpAssets) {
        this(name, null, null, null, monthIncome, cars, oldCarLimit, houses, hasABoat,
                hasAircraft, hasCorpAssets);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(Double monthIncome) {
        this.monthIncome = monthIncome;
    }

    public Integer getCars() {
        return cars;
    }

    public void setCars(Integer cars) {
        this.cars = cars;
    }

    public Integer getOldCarLimit() {
        return oldCarLimit;
    }

    public void setOldCarLimit(Integer oldCarLimit) {
        this.oldCarLimit = oldCarLimit;
    }

    public Integer getHouses() {
        return houses;
    }

    public void setHouses(Integer houses) {
        this.houses = houses;
    }

    public boolean isHasABoat() {
        return hasABoat;
    }

    public void setHasABoat(boolean hasABoat) {
        this.hasABoat = hasABoat;
    }

    public boolean isHasAircraft() {
        return hasAircraft;
    }

    public void setHasAircraft(boolean hasAircraft) {
        this.hasAircraft = hasAircraft;
    }

    public boolean isHasCorpAssets() {
        return hasCorpAssets;
    }

    public void setHasCorpAssets(boolean hasCorpAssets) {
        this.hasCorpAssets = hasCorpAssets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return hasABoat == person.hasABoat && hasAircraft == person.hasAircraft && hasCorpAssets == person.hasCorpAssets && Objects.equals(name, person.name) && Objects.equals(address, person.address) && Objects.equals(age, person.age) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(monthIncome, person.monthIncome) && Objects.equals(cars, person.cars) && Objects.equals(oldCarLimit, person.oldCarLimit) && Objects.equals(houses, person.houses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, age, phoneNumber, monthIncome, cars, oldCarLimit, houses, hasABoat, hasAircraft, hasCorpAssets);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", addres='" + address + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", monthIncome=" + monthIncome +
                ", cars=" + cars +
                ", oldCarLimit=" + oldCarLimit +
                ", houses=" + houses +
                ", hasABoat=" + hasABoat +
                ", hasAircraft=" + hasAircraft +
                ", hasCorpAssets=" + hasCorpAssets +
                '}';
    }
}
