package javastuff.codewars;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array, find the int that appears an odd number of times.
 * There will always be only one integer that appears an odd number of times.
 */
public class FindTheOddInt {

    public static int findIt1(int[] ints) {
        Set<Integer> candidates = new HashSet<>();

        for(int i=0; i < ints.length; i++) {
            final int currentNumber = ints[i];
            if(candidates.contains(currentNumber)) {
                candidates.remove(currentNumber);
            } else {
                candidates.add(currentNumber);
            }
        }

        List<Integer> finalCandidates = new ArrayList<>(candidates);
        return finalCandidates.get(0);
    }

    public static int findIt2(int[] ints) {
        int odd = 0;
        for (int item: ints) {
            /**
             * XOR will cancel out every time you XOR with the same number so 1^1=0 but 1^1^1=1 so every pair should
             * cancel out leaving the odd number out
             */
            odd = odd ^ item;
        }

        return odd;
    }
}
