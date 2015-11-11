package javastuff.codility;

import java.awt.*;
import java.awt.geom.Line2D;

/**
 * נתונים שני ישרים במישור (כל קו ע"י שתי 2 נקודות של התחלה וסוף הישר כלומר סה"כ הפונקציה מקבלת 4 נקודות במישור כל נקודה כידוע מיוצגת ע"י שני מספרים X Y ) צריך להחזיר האם הישרים נחתכים (בתוך התחום של הישרים כלומר בין הנקודות של הישרים)
 */

public class LineIntersect {

    public static boolean isLineIntersect(Point h1, Point h2, Point r1, Point r2) {
        //it's not working. calculating segment and not line.
        Line2D.Double line1 = new Line2D.Double(h1.getX(), h1.getY(), h2.getX(), h2.getY());
        Line2D.Double line2 = new Line2D.Double(r1.getX(), r1.getY(), r2.getX(), r2.getY());
        return line1.intersectsLine(line2);
    }
}
