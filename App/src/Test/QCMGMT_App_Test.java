package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    double eps = 1e-3;

    @Test
    void testAddition_TargetFeet() {
        var result = QCMGMT_App.QuantityLength.add(
                new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET),
                new QCMGMT_App.QuantityLength(12, QCMGMT_App.LengthUnit.INCH),
                QCMGMT_App.LengthUnit.FEET
        );
        assertEquals(2, result.getValue(), eps);
    }

    @Test
    void testAddition_TargetInches() {
        var result = QCMGMT_App.QuantityLength.add(
                1, QCMGMT_App.LengthUnit.FEET,
                12, QCMGMT_App.LengthUnit.INCH,
                QCMGMT_App.LengthUnit.INCH
        );
        assertEquals(24, result.getValue(), eps);
    }

    @Test
    void testAddition_TargetYards() {
        var result = QCMGMT_App.QuantityLength.add(
                1, QCMGMT_App.LengthUnit.FEET,
                12, QCMGMT_App.LengthUnit.INCH,
                QCMGMT_App.LengthUnit.YARDS
        );
        assertEquals(0.6667, result.getValue(), 1e-2);
    }

    @Test
    void testAddition_TargetCentimeters() {
        var result = QCMGMT_App.QuantityLength.add(
                1, QCMGMT_App.LengthUnit.INCH,
                1, QCMGMT_App.LengthUnit.INCH,
                QCMGMT_App.LengthUnit.CENTIMETERS
        );
        assertEquals(5.08, result.getValue(), 1e-2);
    }

    @Test
    void testAddition_Commutativity() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(12, QCMGMT_App.LengthUnit.INCH);

        var r1 = QCMGMT_App.QuantityLength.add(a, b, QCMGMT_App.LengthUnit.YARDS);
        var r2 = QCMGMT_App.QuantityLength.add(b, a, QCMGMT_App.LengthUnit.YARDS);

        assertTrue(r1.equals(r2));
    }

    @Test
    void testAddition_WithZero() {
        var result = QCMGMT_App.QuantityLength.add(
                5, QCMGMT_App.LengthUnit.FEET,
                0, QCMGMT_App.LengthUnit.INCH,
                QCMGMT_App.LengthUnit.YARDS
        );
        assertEquals(1.6667, result.getValue(), 1e-2);
    }

    @Test
    void testAddition_Negative() {
        var result = QCMGMT_App.QuantityLength.add(
                5, QCMGMT_App.LengthUnit.FEET,
                -2, QCMGMT_App.LengthUnit.FEET,
                QCMGMT_App.LengthUnit.INCH
        );
        assertEquals(36, result.getValue(), eps);
    }

    @Test
    void testNullTargetUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> QCMGMT_App.QuantityLength.add(
                        1, QCMGMT_App.LengthUnit.FEET,
                        12, QCMGMT_App.LengthUnit.INCH,
                        null
                )
        );
    }

    @Test
    void testLargeToSmallScale() {
        var result = QCMGMT_App.QuantityLength.add(
                1000, QCMGMT_App.LengthUnit.FEET,
                500, QCMGMT_App.LengthUnit.FEET,
                QCMGMT_App.LengthUnit.INCH
        );
        assertEquals(18000, result.getValue(), eps);
    }

    @Test
    void testSmallToLargeScale() {
        var result = QCMGMT_App.QuantityLength.add(
                12, QCMGMT_App.LengthUnit.INCH,
                12, QCMGMT_App.LengthUnit.INCH,
                QCMGMT_App.LengthUnit.YARDS
        );
        assertEquals(0.6667, result.getValue(), 1e-2);
    }
}