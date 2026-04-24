package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    @Test
    void testEquality_FeetToFeet_SameValue() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        var b = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_InchToInch_SameValue() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.INCH
        );
        var b = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.INCH
        );
        assertTrue(a.equals(b));
    }

    @Test
    void testEquality_FeetToInch_EquivalentValue() {
        var feet = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        var inch = new QCMGMT_App.QuantityLength(
                12.0, QCMGMT_App.LengthUnit.INCH
        );
        assertTrue(feet.equals(inch));
    }

    @Test
    void testEquality_InchToFeet_EquivalentValue() {
        var inch = new QCMGMT_App.QuantityLength(
                12.0, QCMGMT_App.LengthUnit.INCH
        );
        var feet = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        assertTrue(inch.equals(feet));
    }

    @Test
    void testEquality_FeetDifferentValue() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        var b = new QCMGMT_App.QuantityLength(
                2.0, QCMGMT_App.LengthUnit.FEET
        );
        assertFalse(a.equals(b));
    }

    @Test
    void testEquality_InchDifferentValue() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.INCH
        );
        var b = new QCMGMT_App.QuantityLength(
                2.0, QCMGMT_App.LengthUnit.INCH
        );
        assertFalse(a.equals(b));
    }

    @Test
    void testEquality_SameReference() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        assertTrue(a.equals(a));
    }

    @Test
    void testEquality_NullComparison() {
        var a = new QCMGMT_App.QuantityLength(
                1.0, QCMGMT_App.LengthUnit.FEET
        );
        assertFalse(a.equals(null));
    }

    @Test
    void testEquality_NullUnit() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new QCMGMT_App.QuantityLength(1.0, null)
        );
    }
}