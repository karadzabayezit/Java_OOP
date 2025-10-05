import java.util.Objects;

public class Wheel {
    public int d;

    public Wheel(int d) {
        this.d = d;
    }

    public int getDiameter() {
        return this.d;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;

        if (other == null || this.getClass() != other.getClass())
            return false;

        Wheel typedOther = (Wheel) other;

        return this.d == typedOther.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.d);
    }
}
