package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    double eps = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                QCMGMT_App.QuantityLength.convert(
                        1,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.INCH
                ),
                eps);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                QCMGMT_App.QuantityLength.convert(
                        24,
                        QCMGMT_App.LengthUnit.INCH,
                        QCMGMT_App.LengthUnit.FEET
                ),
                eps);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36,
                QCMGMT_App.QuantityLength.convert(
                        1,
                        QCMGMT_App.LengthUnit.YARDS,
                        QCMGMT_App.LengthUnit.INCH
                ),
                eps);
    }

    @Test
    void testConversion_FeetToYards() {
        assertEquals(2,
                QCMGMT_App.QuantityLength.convert(
                        6,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.YARDS
                ),
                eps);
    }

    @Test
    void testConversion_CmToInches() {
        assertEquals(1.0,
                QCMGMT_App.QuantityLength.convert(
                        2.54,
                        QCMGMT_App.LengthUnit.CENTIMETERS,
                        QCMGMT_App.LengthUnit.INCH
                ),
                1e-4);
    }

    @Test
    void testRoundTrip() {
        double x = 5.5;

        double converted =
                QCMGMT_App.QuantityLength.convert(
                        x,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.CENTIMETERS
                );

        double back =
                QCMGMT_App.QuantityLength.convert(
                        converted,
                        QCMGMT_App.LengthUnit.CENTIMETERS,
                        QCMGMT_App.LengthUnit.FEET
                );

        assertEquals(x, back, 1e-5);
    }

    @Test
    void testZero() {
        assertEquals(0,
                QCMGMT_App.QuantityLength.convert(
                        0,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.INCH
                ),
                eps);
    }

    @Test
    void testNegative() {
        assertEquals(-12,
                QCMGMT_App.QuantityLength.convert(
                        -1,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.INCH
                ),
                eps);
    }

    @Test
    void testSameUnit() {
        assertEquals(5,
                QCMGMT_App.QuantityLength.convert(
                        5,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.FEET
                ),
                eps);
    }

    @Test
    void testNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QCMGMT_App.QuantityLength.convert(
                        1,
                        null,
                        QCMGMT_App.LengthUnit.FEET
                )
        );
    }

    @Test
    void testNaN() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QCMGMT_App.QuantityLength.convert(
                        Double.NaN,
                        QCMGMT_App.LengthUnit.FEET,
                        QCMGMT_App.LengthUnit.INCH
                )
        );
    }
}