package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    @Test
    void testEquality_YardToYard_SameValue() {
        var a = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        var b = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_YardToYard_DifferentValue() {
        var a = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        var b = new QCMGMT_App.QuantityLength(
                2, QCMGMT_App.LengthUnit.YARDS
        );
        assertFalse(a.equals(b));
    }

    @Test
    void testEquality_YardToFeet() {
        var yard = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        var feet = new QCMGMT_App.QuantityLength(
                3, QCMGMT_App.LengthUnit.FEET
        );
        assertTrue(yard.equals(feet));
    }

    @Test
    void testEquality_YardToInches() {
        var yard = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        var inch = new QCMGMT_App.QuantityLength(
                36, QCMGMT_App.LengthUnit.INCH
        );
        assertTrue(yard.equals(inch));
    }

    @Test
    void testEquality_CmToCm() {
        var a = new QCMGMT_App.QuantityLength(
                2, QCMGMT_App.LengthUnit.CENTIMETERS
        );
        var b = new QCMGMT_App.QuantityLength(
                2, QCMGMT_App.LengthUnit.CENTIMETERS
        );
        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_CmToInch() {
        var cm = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.CENTIMETERS
        );
        var inch = new QCMGMT_App.QuantityLength(
                0.393701, QCMGMT_App.LengthUnit.INCH
        );
        assertTrue(cm.equals(inch));
    }

    @Test
    void testEquality_CmToFeet_NotEqual() {
        var cm = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.CENTIMETERS
        );
        var feet = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.FEET
        );
        assertFalse(cm.equals(feet));
    }

    @Test
    void testTransitiveProperty() {
        var yard = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        var feet = new QCMGMT_App.QuantityLength(
                3, QCMGMT_App.LengthUnit.FEET
        );
        var inch = new QCMGMT_App.QuantityLength(
                36, QCMGMT_App.LengthUnit.INCH
        );

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inch));
        assertTrue(yard.equals(inch));
    }

    @Test
    void testSameReference() {
        var a = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        assertTrue(a.equals(a));
    }

    @Test
    void testNullComparison() {
        var a = new QCMGMT_App.QuantityLength(
                1, QCMGMT_App.LengthUnit.YARDS
        );
        assertFalse(a.equals(null));
    }

    @Test
    void testNullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QCMGMT_App.QuantityLength(1, null)
        );
    }
}