package javastuff.codility;

/**
 בנה פונקציה המקבלת מערך של מספרים INT ומחזירה מספר P המקיים שהסכום של P אברי המערך מתחילת המערך וסכום של P אברי המערך מסוף המערך שווים
 אם לא קיים P כזה יש להחזיר -1
 */
public class SumInBeginningAndAndIsTheSame {

    public static int isSumInBeginningAndAndIsTheSame(int[] numbers) {
        int startSum = 0;
        int endSum = 0;
        int numberOfDigitsToSum = -1;

        for(int index = 0; index < numbers.length - 1; index++) {
            startSum += numbers[index];
            endSum += numbers[numbers.length - 1 - index];

            if(startSum == endSum){
                numberOfDigitsToSum = index + 1;
                return numberOfDigitsToSum;
            }
        }

        return numberOfDigitsToSum;
    }
}
