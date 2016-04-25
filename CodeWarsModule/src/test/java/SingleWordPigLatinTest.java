import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleWordPigLatinTest {

    private SingleWordPigLatin p;

    @Before
    public void setUp() throws Exception {
        p = new SingleWordPigLatin();
    }

    @Test
    public void testMap() {
        assertEquals("apmay", p.translate("map"));
    }

    @Test
    public void testegg() {
        assertEquals("eggway", p.translate("egg"));
    }

    @Test
    public void testspaghetti() {
        assertEquals("aghettispay", p.translate("spaghetti"));
    }

    @Test
    public void test123() {
        assertEquals("", p.translate("123"));
    }

    @Test
    public void testtes3t5() {
        assertEquals("", p.translate("tes3t5"));
    }

    @Test
    public void testCCCC() {
        assertEquals("ccccay", p.translate("CCCC"));
    }
}
