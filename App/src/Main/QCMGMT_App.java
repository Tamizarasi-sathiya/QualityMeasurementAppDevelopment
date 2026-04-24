package Main;

public class QCMGMT_App {

    public static void main(String[] args) {

        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        QuantityLength b =
                new QuantityLength(12, LengthUnit.INCHES);

        System.out.println("Equal: " + a.equals(b));

        System.out.println("Convert to inches: " +
                a.convertTo(LengthUnit.INCHES));

        System.out.println("Addition (feet): " +
                a.add(b, LengthUnit.FEET));

        System.out.println("Yard + Feet (yards): " +
                new QuantityLength(1, LengthUnit.YARDS)
                        .add(
                                new QuantityLength(3, LengthUnit.FEET),
                                LengthUnit.YARDS
                        )
        );
    }
}