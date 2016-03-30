package basicjava;

public class ManipulationOnNumbers {

    public static void main (String[] args) {

        System.out.println("Is number 12321 is a palindrome: " + checkIfNumPalindrome(12321));
        System.out.println("Is number 12345 is a palindrome: " + checkIfNumPalindrome(12345));
    }

    private static boolean checkIfNumPalindrome(int numToCheck) {
        int number = numToCheck;
        int reversedNum = 0;

        while(number > 0) {
            int digit = number % 10;
            reversedNum = reversedNum * 10 + digit;
            number = number / 10;
        }

        return reversedNum == numToCheck;
    }
}
