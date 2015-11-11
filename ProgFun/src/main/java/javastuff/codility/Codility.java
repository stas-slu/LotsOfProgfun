package javastuff.codility;

import scala.Array;

import java.util.Arrays;

public class Codility {

    public static void main(String[] args) {
        int nubmer = 9;
        String numberBinary = Integer.toBinaryString(9);

        int len = 100000;
        int[] r = new int[len];
        Arrays.fill(r, 0);
    }

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Triangle-Triangle/cu6k/56164b9f0cf25fa7fe2d0a3c
    public int triangleSolution(int[] arr) {

        Arrays.sort(arr);

        for(int i=0; i<arr.length-2;i++){
            if(arr[i]+arr[i+1]>arr[i+2]){
                return 1;
            }
        }
        return 0;
    }

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Distinct-Distinct/cu6k/56164bcd0cf27d786fdc9918
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

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Max-Product-Of-Three-MaxProductOfThree/cu6k/56164b5e0cf25fa7fe2d0972
    public int maxProductOfThreeSolution(int[] arr) {

        Arrays.sort(arr);

        int firstMax = arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3];
        int secondMax = arr[0] * arr[1] * arr[arr.length - 1]; //it's needed because 2 digits with minus could appear
        return Math.max(firstMax, secondMax);
    }

    public static void twoMinimumNumbersInArray() { //it's not NLOGN but just N!
        int[] myArray = { 5, 8, 12, 9, 50, 11, 4 };
        System.out.println(Arrays.toString(myArray));

        int[] lowestValues = new int[3];
        Arrays.fill(lowestValues, Integer.MAX_VALUE);

        for(int n : myArray) {
            if(n < lowestValues[2]) {
                lowestValues[2] = n;
                Arrays.sort(lowestValues);
            }
        }
        System.out.println(Arrays.toString(lowestValues));
    }

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Minimum-Average-Two-Slice-MinAvgTwoSlice/cu6k/56164ae60cf2f8c14658cd6b
    public int minAvgTwoSliceSolution(int[] arr) {
        return 0; //TODO
        //here a solution: http://codesays.com/2014/solution-to-min-avg-two-slice-by-codility/
    }

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Passing-Cars-PassingCars/cu6k/56164aa10cf27d786fdc9880
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

    //http://ridg18.wix.com/codingtutorial#!Codility-Solutions-Count-Div-CountDiv/cu6k/56164a540cf2a7bb74cd86f1
    public int countDivSolution(int A, int B, int K) {
        return 0; //TODO
        //solution http://stackoverflow.com/questions/25661519/find-the-number-of-divisors-for-a-number-in-range
        // The concept here is to find how much B get divided by K MINUS how much A get divided
    }
}
