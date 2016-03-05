package javastuff.codility;

/**
 * Function receives array of ints and returns number P that sum of P numbers in beggining and P numbers
 * in the end are equal
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
