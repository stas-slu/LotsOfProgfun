import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class IdentifierCheckerTest {

    @Test
    public void testValid1() {
        assertEquals(true, IdentifierChecker.isValid("i1"));
        assertEquals(true, IdentifierChecker.isValidSmarter("i1"));
    }

    @Test
    public void testValid2() {
        assertEquals(true, IdentifierChecker.isValid("wo_rd"));
        assertEquals(true, IdentifierChecker.isValidSmarter("wo_rd"));
    }

    @Test
    public void testValid3() {
        assertEquals(true, IdentifierChecker.isValid("i"));
        assertEquals(true, IdentifierChecker.isValidSmarter("i"));
    }

    @Test
    public void testValid4() {
        assertEquals(true, IdentifierChecker.isValid("b2h"));
        assertEquals(true, IdentifierChecker.isValidSmarter("b2h"));
    }

    @Test
    public void testInvalid1() {
        assertEquals(false, IdentifierChecker.isValid("1i"));
        assertEquals(false, IdentifierChecker.isValidSmarter("1i"));
    }

    @Test
    public void testInvalid2() {
        assertEquals(false, IdentifierChecker.isValid("wo rd"));
        assertEquals(false, IdentifierChecker.isValidSmarter("wo rd"));
    }

    @Test
    public void testInvalid3() {
        assertEquals(false, IdentifierChecker.isValid("!b2h"));
        assertEquals(false, IdentifierChecker.isValidSmarter("!b2h"));
    }

    @Test
    public void testInvalid4() {
        assertEquals(false, IdentifierChecker.isValid(""));
        assertEquals(false, IdentifierChecker.isValidSmarter(""));
    }
}