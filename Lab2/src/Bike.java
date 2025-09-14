import java.util.List;
import java.util.Objects;

abstract class Bike implements Cloneable {

    protected int wheelCount;
    protected Wheel wheel;

    public Bike(int wheelCount, int wheelDiameter) {
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

class Unicycle extends Bike {
    public Unicycle(int wheelDiameter) {
        super(1, wheelDiameter);
    }

    @Override
    public void use() {
        System.out.println("Using a one-cycle bike");
    }

    @Override
    public void repair() {
        System.out.println("Repairing one-cycle bike");
    }

    @Override
    public void build() {
        System.out.println("Building one-cycle bike");
    }
}

class Bicycle extends Bike {
    public Bicycle(int wheelDiameter) {
        super(2, wheelDiameter);
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

class Tricycle extends Bike {
    public Tricycle(int wheelDiameter) {
        super(3, wheelDiameter);
    }

    @Override
    public void use() {
        System.out.println("Using a three-cycle bike");
    }

    @Override
    public void repair() {
        System.out.println("Repairing three-cycle bike");
    }

    @Override
    public void build() {
        System.out.println("Building three-cycle bike");
    }
}

class RepairService {
    public void repairBike(Bike bike) {
        bike.repair();
    }

    public void repairAll(List<Bike> bikes) {
        for (Bike bike : bikes) {
            repairBike(bike);
        }
    }
}
