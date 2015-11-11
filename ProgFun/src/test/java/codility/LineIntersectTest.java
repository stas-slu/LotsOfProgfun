package codility;

import javastuff.codility.LineIntersect;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LineIntersectTest {

    @Test
    public void testLineIntersect1(){
        final boolean isLineIntersect = LineIntersect.isLineIntersect(
                new Point(0,0),
                new Point(9,9),
                new Point(1,1),
                new Point(10,10));
        assertTrue(isLineIntersect);
    }

    @Test
    public void testLineIntersect2(){
        final boolean isLineIntersect = LineIntersect.isLineIntersect(
                new Point(0,0),
                new Point(9,9),
                new Point(1,0),
                new Point(8,8));
        assertFalse(isLineIntersect);
    }
}
