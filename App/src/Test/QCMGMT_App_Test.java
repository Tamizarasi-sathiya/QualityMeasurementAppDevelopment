package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    double eps = 1e-6;

    @Test
    void testAddition_FeetPlusFeet() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(2, QCMGMT_App.LengthUnit.FEET);

        assertEquals(3, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_InchesPlusInches() {
        var a = new QCMGMT_App.QuantityLength(6, QCMGMT_App.LengthUnit.INCH);
        var b = new QCMGMT_App.QuantityLength(6, QCMGMT_App.LengthUnit.INCH);

        assertEquals(12, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_FeetPlusInches() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(12, QCMGMT_App.LengthUnit.INCH);

        assertEquals(2, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_InchPlusFeet() {
        var a = new QCMGMT_App.QuantityLength(12, QCMGMT_App.LengthUnit.INCH);
        var b = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);

        assertEquals(24, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_YardPlusFeet() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.YARDS);
        var b = new QCMGMT_App.QuantityLength(3, QCMGMT_App.LengthUnit.FEET);

        assertEquals(2, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_CmPlusInch() {
        var a = new QCMGMT_App.QuantityLength(2.54, QCMGMT_App.LengthUnit.CENTIMETERS);
        var b = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.INCH);

        assertEquals(5.08, a.add(b).getValue(), 1e-3);
    }

    @Test
    void testAddition_Commutative() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(12, QCMGMT_App.LengthUnit.INCH);

        assertTrue(a.add(b).equals(b.add(a)));
    }

    @Test
    void testAddition_Zero() {
        var a = new QCMGMT_App.QuantityLength(5, QCMGMT_App.LengthUnit.FEET);
        var zero = new QCMGMT_App.QuantityLength(0, QCMGMT_App.LengthUnit.INCH);

        assertEquals(5, a.add(zero).getValue(), eps);
    }

    @Test
    void testAddition_Negative() {
        var a = new QCMGMT_App.QuantityLength(5, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(-2, QCMGMT_App.LengthUnit.FEET);

        assertEquals(3, a.add(b).getValue(), eps);
    }

    @Test
    void testAddition_NullOperand() {
        var a = new QCMGMT_App.QuantityLength(1, QCMGMT_App.LengthUnit.FEET);

        assertThrows(
                IllegalArgumentException.class,
                () -> a.add(null)
        );
    }

    @Test
    void testLargeValues() {
        var a = new QCMGMT_App.QuantityLength(1e6, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(1e6, QCMGMT_App.LengthUnit.FEET);

        assertEquals(2e6, a.add(b).getValue(), eps);
    }

    @Test
    void testSmallValues() {
        var a = new QCMGMT_App.QuantityLength(0.001, QCMGMT_App.LengthUnit.FEET);
        var b = new QCMGMT_App.QuantityLength(0.002, QCMGMT_App.LengthUnit.FEET);

        assertEquals(0.003, a.add(b).getValue(), 1e-9);
    }
}