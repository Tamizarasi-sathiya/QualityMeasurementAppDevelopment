package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QCMGMT_App_Test {
    @Test
    void testEquality_SameValue() {
        QCMGMT_App.Feet a =
                new QCMGMT_App.Feet(1.0);
        QCMGMT_App.Feet b =
                new QCMGMT_App.Feet(1.0);
        assertTrue(a.equals(b));
    }
    @Test
    void testEquality_DifferentValue() {
        QCMGMT_App.Feet a =
                new QCMGMT_App.Feet(1.0);
        QCMGMT_App.Feet b =
                new QCMGMT_App.Feet(2.0);
        assertFalse(a.equals(b));
    }
    @Test
    void testEquality_NullComparison() {
        QCMGMT_App.Feet a =
                new QCMGMT_App.Feet(1.0);
        assertFalse(a.equals(null));
    }
    @Test
    void testEquality_SameReference() {
        QCMGMT_App.Feet a =
                new QCMGMT_App.Feet(1.0);
        assertTrue(a.equals(a));
    }
}