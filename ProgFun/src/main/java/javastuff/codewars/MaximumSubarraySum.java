package javastuff.codewars;

/**
 * The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
 *
 * For example:
 * Max.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
 * should be 6: {4, -1, 2, 1}
 *
 * Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array.
 * If the list is made up of only negative numbers, return 0 instead.
 * Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
 */
public class MaximumSubarraySum {

    public static int sequence(int[] ints) {
        int maxEndingHere = 0, maxEver = 0;

        for(int num : ints) {
            maxEndingHere = Math.max(0, maxEndingHere + num);
            maxEver = Math.max(maxEver, maxEndingHere);
        }

        return maxEver;
    }
}