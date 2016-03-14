package javastuff.basicjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ManipulationOfStrings {

    public static void main(String[] args) {
        String string = "stas trying strings";

        new ManipulationOfStrings().readNextWord(string);

        iterateOverString(string);

        reverseStringTraditionalApproach(string);
        reverseStringRecursionApproach(string);
        reverseStringWords(string);
    }

    private void readNextWord(String string) {
        ClassLoader classLoader = getClass().getClassLoader();
        File myFile = new File(classLoader.getResource("test-text.txt").getFile());

        try(Scanner scanner = new Scanner(myFile)) {

            while(scanner.hasNextLine()) {
                final String line = scanner.nextLine();
                System.out.println(String.format("Line: %s", line));
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void iterateOverString(String string) {
        for(int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            System.out.println(String.format("Char is: %c", c));
        }

        System.out.println();

        for(char c : string.toCharArray()) {
            System.out.println(String.format("Char is: %c", c));
        }
    }

    private static void reverseStringTraditionalApproach(String string) {
        // Using traditional approach
        String result="";
        for (int i=string.length()-1; i>=0; i--) {
            result = result + string.charAt(i);
        }
        System.out.println("Reverse with for loop: " + result);

        // Using StringBuffer class
        StringBuffer buffer = new StringBuffer(string);
        System.out.println("Reverse with StringBuffer: " + buffer.reverse());

        //using chars
        char[] chars = string.toCharArray();
        int start = 0;
        int end = string.length() - 1;
        char tmp;
        while(start < end) {
            tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;
            start++;
            end--;
        }
        System.out.println("Reverse with chars: " + new String(chars));
    }

    public static void reverseStringWords(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = string.split(" ");

        for (int j = words.length-1; j >= 0; j--) {
            stringBuilder.append(words[j]).append(' ');
        }
        System.out.println("Reverse words: " + stringBuilder);
    }

    public static void reverseStringRecursionApproach(String string) {
        String reverseAlphabet = reverse(string, string.length()-1);
        System.out.println("Reverse recursion: " + reverseAlphabet);
    }

    private static String reverse(String stringToReverse, int index){
        if(index == 0){
            return stringToReverse.charAt(0) + "";
        }

        char letter = stringToReverse.charAt(index);
        return letter + reverse(stringToReverse, index-1);
    }
}
