package codewars;

import javastuff.codewars.MaximumSubarraySum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


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
public class MaximumSubarraySumTest {

    @Test
    public void testEmptyArray() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaximumSubarraySum.sequence(new int[]{}));
    }

    @Test
    public void testEmptyOnlyPositive() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 17,
                     MaximumSubarraySum.sequence(new int[]{4, 1, 2, 1, 5, 4}));
    }

    @Test
    public void testEmptyOnlyNegative() throws Exception {
        assertEquals("Empty arrays should have a max of 0", 0, MaximumSubarraySum.sequence(new int[]{-2, -1, -4}));
    }


    @Test
    public void testExampleArray() throws Exception {
        assertEquals("Example array should have a max of 6", 6, MaximumSubarraySum.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
