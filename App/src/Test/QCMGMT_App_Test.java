package Test;

import Main.LengthUnit;
import Main.QuantityLength;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    @Test
    void testFeetEqualsInches() {
        assertEquals(
                new QuantityLength(1, LengthUnit.FEET),
                new QuantityLength(12, LengthUnit.INCHES)
        );
    }

    @Test
    void testYardEqualsFeet() {
        assertEquals(
                new QuantityLength(1, LengthUnit.YARDS),
                new QuantityLength(3, LengthUnit.FEET)
        );
    }

    @Test
    void testCmEqualsInch() {
        assertEquals(
                new QuantityLength(2.54, LengthUnit.CENTIMETERS),
                new QuantityLength(1, LengthUnit.INCHES)
        );
    }

    @Test
    void testConvertFeetToInches() {
        assertEquals(
                12,
                QuantityLength.convert(
                        1,
                        LengthUnit.FEET,
                        LengthUnit.INCHES
                ),
                0.001
        );
    }

    @Test
    void testAddition() {
        QuantityLength result =
                new QuantityLength(1, LengthUnit.FEET)
                        .add(
                                new QuantityLength(12, LengthUnit.INCHES),
                                LengthUnit.FEET
                        );

        assertEquals(
                new QuantityLength(2, LengthUnit.FEET),
                result
        );
    }

    @Test
    void testNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QuantityLength(1, null)
        );
    }

    @Test
    void testSameReference() {
        QuantityLength a =
                new QuantityLength(1, LengthUnit.FEET);

        assertEquals(a, a);
    }
}