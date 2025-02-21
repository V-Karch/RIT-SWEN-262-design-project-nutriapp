package design.Model;

public enum Intensity {
    LOW(5.0),
    MEDIUM(7.5),
    HIGH(10.0);

    private double value;

    private Intensity(double value) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }
}
