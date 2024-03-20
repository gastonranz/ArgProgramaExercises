package Class5and7;

import java.util.Objects;

public class Auto {
    private String name;
    private int serie;

    public Auto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSerie() {
        return serie;
    }

    public void setSerie(int serie) {
        this.serie = serie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Auto auto = (Auto) o;
        return Objects.equals(name, auto.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
