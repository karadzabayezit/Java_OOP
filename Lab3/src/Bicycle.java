import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

abstract class Bike implements Cloneable {

    private int wheelCount;
    private Wheel wheel;
    private String name;
    private int year;

    public Bike(String name, int year, int wheelCount, int wheelDiameter) {
        this.name = name;
        this.year = year;
        this.wheelCount = wheelCount;
        this.wheel = new Wheel(wheelDiameter);
    }

    public abstract void use();

    public abstract void repair();

    public abstract void build();

    public void buy() {
        System.out.println("Buying " + this.wheelCount + "bike");
    }

    public int getWheelCount() {
        return this.wheelCount;
    }

    public int getWheelDiameter() {
        return this.wheel.getDiameter();
    }

    public int getFullWheelDiameter() {
        return this.wheelCount * this.wheel.d;
    }

    public String getFullName() {
        return this.name + " " + this.year;
    }

    public String getName() {
        return this.name;
    }

    public int getYear() {
        return this.year;
    }

    // OVERRIDES
    @Override
    public Bike clone() throws CloneNotSupportedException {
        Bike clone = (Bike) super.clone();
        clone.wheel = new Wheel(this.wheel.d);
        return clone;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Bike typedOther = (Bike) other;

        return this.wheelCount == typedOther.wheelCount && this.wheel.d == typedOther.wheel.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.wheel.d, this.wheelCount);
    }
}

class Bicycle extends Bike {
    public Bicycle(String name, int year, int wheelCount, int wheelDiameter) {
        super(name, year, wheelCount, wheelDiameter);
    }

    @Override
    public void use() {
        System.out.println("Using a two-cycle bike");
    }

    @Override
    public void repair() {
        System.out.println("Repairing two-cycle bike");
    }

    @Override
    public void build() {
        System.out.println("Building two-cycle bike");
    }
}

class Bicycles  {
    private ArrayList<Bicycle> bikes;

    public Bicycles() {
        this.bikes = new ArrayList<Bicycle>();
    }

    public ArrayList<Bicycle> getBikes() {
        return new ArrayList<Bicycle>(this.bikes);
    }

    public void add(Bicycle bike) {
        this.bikes.add(bike);
    }

    public void printBikes() {
        for (Bicycle bike : this.bikes) {
            System.out.println(bike.getFullName() + ", " + bike.getWheelCount() + "-" + bike.getWheelDiameter());
        }
    }

    public void sort() {
        this.bikes.sort(Comparator.comparing(Bicycle::getName));
    }

    public void sort(SortCriteria criteria) {
        switch (criteria) {
            case BY_NAME:
                this.sort();
                break;
            case BY_WHEEL_SIZE:
                this.bikes.sort(Comparator.comparing(Bicycle::getFullWheelDiameter));
                break;
            case BY_YEAR:
                this.bikes.sort(Comparator.comparing(Bicycle::getYear).reversed());
                break;
            case BY_NAME_YEAR:
                this.bikes.sort(
                        Comparator.comparing(Bicycle::getName).thenComparing(Bicycle::getYear,
                                Comparator.reverseOrder()));
                break;

            default:
                throw new IllegalArgumentException("Unknown sort criteria: " + criteria);
        }
    }
}