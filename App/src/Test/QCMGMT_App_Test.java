package Test;

import Main.QCMGMT_App;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QCMGMT_App_Test {

    @Test
    void testFeetEquality_SameValue() {
        assertTrue(QCMGMT_App.compareFeet(1.0, 1.0));
    }

    @Test
    void testFeetEquality_DifferentValue() {
        assertFalse(QCMGMT_App.compareFeet(1.0, 2.0));
    }

    @Test
    void testFeetEquality_NullComparison() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(1.0);
        assertFalse(f.equals(null));
    }

    @Test
    void testFeetEquality_SameReference() {
        QCMGMT_App.Feet f = new QCMGMT_App.Feet(1.0);
        assertTrue(f.equals(f));
    }

    @Test
    void testInchesEquality_SameValue() {
        assertTrue(QCMGMT_App.compareInches(1.0, 1.0));
    }

    @Test
    void testInchesEquality_DifferentValue() {
        assertFalse(QCMGMT_App.compareInches(1.0, 2.0));
    }

    @Test
    void testInchesEquality_NullComparison() {
        QCMGMT_App.Inches i = new QCMGMT_App.Inches(1.0);
        assertFalse(i.equals(null));
    }

    @Test
    void testInchesEquality_SameReference() {
        QCMGMT_App.Inches i = new QCMGMT_App.Inches(1.0);
        assertTrue(i.equals(i));
    }

    @Test
    void testEquality_NonNumericInput() {
        QCMGMT_App.Inches i = new QCMGMT_App.Inches(1.0);
        String text = "abc";
        assertFalse(i.equals(text));
    }
}