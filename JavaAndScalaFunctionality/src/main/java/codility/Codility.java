package codility;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Codility {

    public static void main(String[] args) {
        //working with binary numbers
        int nubmer = 9;
        String numberBinary = Integer.toBinaryString(nubmer);

        //Filling array with zeroes
        int len = 100000;
        int[] r = new int[len];
        Arrays.fill(r, 0);

        //Parsing binary integer to int
        int a = Integer.parseInt("110", 2);
    }

    /**
     * A zero-indexed array A consisting of N integers is given.
     * A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:
     * A[P] + A[Q] > A[R],
     * A[Q] + A[R] > A[P],
     * A[R] + A[P] > A[Q].
     *
     * Write a function that returns 1 if there exists a triangular triplet
     *
     * http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Triangle-Triangle/cu6k/56164b9f0cf25fa7fe2d0a3c
     */
    public int triangleSolution(int[] arr) {

        Arrays.sort(arr);

        for(int i=0; i<arr.length-2;i++){
            if(arr[i]+arr[i+1]>arr[i+2]){
                return 1;
            }
        }
        return 0;
    }

    /**
     * given a zero-indexed array A consisting of N integers, returns the number of distinct values in array A.
     *
     * http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Distinct-Distinct/cu6k/56164bcd0cf27d786fdc9918
     */
    public int distinctSolution(int[] arr) {

        if(arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return 1;
        }

        Arrays.sort(arr);

        int count=1;
        int lastElement=arr[0];

        for(int i=1; i<arr.length; i++){
            if(arr[i]!=lastElement){
                count++;
                lastElement = arr[i];
            }
        }
        return count;
    }

    /**
     * A non-empty zero-indexed array A consisting of N integers is given.
     * The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).
     * Find the maximal product of any triplet
     *
     * http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Max-Product-Of-Three-MaxProductOfThree/cu6k/56164b5e0cf25fa7fe2d0972
     */
    public int maxProductOfThreeSolution(int[] arr) {

        Arrays.sort(arr);

        int firstMax = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
        int secondMax = arr[0] * arr[1] * arr[arr.length - 1]; //it's needed because 2 digits with minus could appear
        return Math.max(firstMax, secondMax);
    }

    /**
     * Find 2 lowest number in array in O(n), not O(nlogn) as standard sorting
     */
    public static void twoMinimumNumbersInArray() {
        int[] myArray = { 5, 8, 12, 9, 50, 11, 4 };
        System.out.println(Arrays.toString(myArray));

        int[] lowestValues = new int[3];
        Arrays.fill(lowestValues, Integer.MAX_VALUE);

        for(int num : myArray) {
            if(num < lowestValues[2]) {
                lowestValues[2] = num;
                Arrays.sort(lowestValues); //im sceptic about this not nlogn
            }
        }
        System.out.println(Arrays.toString(lowestValues));
    }

    /**
     * Passing Cars.
     * Elements of array A represent consecutive cars on a road, Array A contains only 0s and/or 1s:
     * 0 represents a car traveling east -->
     * 1 represents a car traveling west <--
     * The goal is to count passing cars.
     * For example, consider array A such that:
     * A[0] = 0
     * A[1] = 1
     * A[2] = 0
     * A[3] = 1
     * A[4] = 1
     * So, we have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
     *
     * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
     *
     * http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Passing-Cars-PassingCars/cu6k/56164aa10cf27d786fdc9880
     */
    public int passingCarsSolution(int[] arr) {
        int countZeroes = 0;
        int countCars = 0;

        for(int i=0; i<arr.length;i++){
            if(arr[i] == 0){
                countZeroes++;
            }

            if(countZeroes > 0 && arr[i] == 1){
                countCars += countZeroes;
            }

            if(countCars>1000000000){
                return -1;
            }
        }
        return countCars;
    }

    /**
     * Compute number of distinct absolute values of sorted array elements.
     * For example, for [-5, -3, -1, 0, 3, 6] the absolute distinct count is 5, because there is 5 distinct
     * absolute values: 0, 1, 3, 5, 6
     *
     * http://www.martinkysel.com/codility-absdistinct-solution/
     */
    public int absDistinct(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(Math.abs(arr[i]));
        }
        return set.size();
    }

    /**
     * Compute the height of a binary link-tree.
     * Expected worst-case time complexity is O(N)
     * Expected worst-case space complexity is O(N)
     *
     * http://www.martinkysel.com/codility-treeheight-solution/
     * https://codesays.com/2014/solution-to-tree-height-by-codility/
     */
    public int treeHeight1(Tree tree) {
        if(tree == null) {
            return -1;
        }
        int result = 0;

        result = Math.max(result, 1 + treeHeight1(tree.left));
        result = Math.max(result, 1 + treeHeight1(tree.right));

        return result;
    }

    public int treeHeight2(Tree tree) { //this one much better
        if (tree == null) {
            return -1;
        }

        return 1 + Math.max(treeHeight2(tree.left), treeHeight2(tree.right));
    }

    class Tree {
        Tree left;
        Tree right;
        int data;
    }

    /**
     * Find longest sequence of zeros in binary representation of an integer
     *
     * Expected worst-case time complexity is O(log(N))
     * Expected worst-case space complexity is O(1)
     *
     * http://www.martinkysel.com/codility-binarygap-solution/
     * http://stackoverflow.com/questions/8340549/find-longest-series-of-ones-in-a-binary-digit-array
     */
    public int binaryGap(int number) {
        String binaryNum = Integer.toBinaryString(number);

        LinkedList<String> list = new LinkedList<String>(Arrays.asList(binaryNum.split("0+")));
        //very elegant, but because of the sort its run time is O(nlogn). Bad solution.
        Collections.sort(list);
        int maxLength = list.getLast().length();
        return maxLength;
    }
}
