import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SquareDigitTest {
    @Test
    public void test() {
        assertEquals(811181, new SquareDigit().squareDigits(9119));
        assertEquals(9414, new SquareDigit().squareDigits(3212));
        assertEquals(640125, new SquareDigit().squareDigits(8015));
        assertEquals(94900, new SquareDigit().squareDigits(32300));
    }
}