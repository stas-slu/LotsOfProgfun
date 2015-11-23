package javastuff.basicjava;

public class ManipulationOfStrings {

    public static void main(String[] args) {
        String string = "stas trying strings";
        reverseStringTraditionalApproach(string);
        reverseStringRecursionApproach(string);
        reverseStringWords(string);
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
