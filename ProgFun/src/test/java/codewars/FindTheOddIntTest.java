package codewars;

import javastuff.codewars.FindTheOddInt;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FindTheOddIntTest {

    @Test
    public void findTest() {
        assertEquals(5, FindTheOddInt.findIt1(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        assertEquals(-1, FindTheOddInt.findIt1(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        assertEquals(5, FindTheOddInt.findIt1(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        assertEquals(10, FindTheOddInt.findIt1(new int[]{10}));
        assertEquals(10, FindTheOddInt.findIt1(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        assertEquals(1, FindTheOddInt.findIt1(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));

        assertEquals(5, FindTheOddInt.findIt2(new int[]{20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5}));
        assertEquals(-1, FindTheOddInt.findIt2(new int[]{1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5}));
        assertEquals(5, FindTheOddInt.findIt2(new int[]{20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5}));
        assertEquals(10, FindTheOddInt.findIt2(new int[]{10}));
        assertEquals(10, FindTheOddInt.findIt2(new int[]{1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1}));
        assertEquals(1, FindTheOddInt.findIt2(new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10}));
    }
}
