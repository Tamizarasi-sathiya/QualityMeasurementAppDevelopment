package Main;

public enum LengthUnit {

    FEET(1.0),
    INCHES(1.0 / 12.0),
    YARDS(3.0),
    CENTIMETERS(1.0 / 30.48);

    private final double factorToFeet;

    LengthUnit(double factorToFeet) {
        this.factorToFeet = factorToFeet;
    }

    public double getConversionFactor() {
        return factorToFeet;
    }

    public double convertToBaseUnit(double value) {
        return value * factorToFeet;
    }

    public double convertFromBaseUnit(double feetValue) {
        return feetValue / factorToFeet;
    }
}