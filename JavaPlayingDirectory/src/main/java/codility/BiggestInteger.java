package codility;

import java.util.Arrays;

/**
 * Function receives arrays of integers and return the largest number that can be made from its numbers
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
