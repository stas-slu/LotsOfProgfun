package javastuff.codility;

import java.util.*;

/**
 * בנה פונקציה שמקבלת מספר INT ומחזירה את המספר הגדול ביותר שניתן להרכיב עם הספרות של המספר שקיבלה הפונקציה לדוג' הפונק' מקבלת את המספר 251 יש להחזיר 521
 */
public class BiggestInteger {

    public static int findBiggestInteger(int[] numbers) {
        Arrays.sort(numbers);
        StringBuilder stringBuilder = new StringBuilder();

        for(int i : numbers){
            stringBuilder.insert(0, i);
        }

        return Integer.parseInt(stringBuilder.toString());
    }
}
