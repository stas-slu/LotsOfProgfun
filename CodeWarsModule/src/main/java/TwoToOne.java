import java.util.Set;
import java.util.TreeSet;

/**
 * Take 2 strings s1 and s2 including only letters from ato z. Return a new sorted string,
 * the longest possible, containing distinct letters, - each taken only once - coming from s1 or s2.
 *
 * Examples:
 * a = "xyaabbbccccdefww"
 * b = "xxxxyyyyabklmopq"
 * longest(a, b) -> "abcdefklmopqwxy"
 * a = "abcdefghijklmnopqrstuvwxyz"
 * longest(a, a) -> "abcdefghijklmnopqrstuvwxyz"
 *
 */
public class TwoToOne {
    public static String longest (String s1, String s2) {
        Set<Character> chars = new TreeSet<>();
        for(char c1: s1.toCharArray()) {
            chars.add(c1);
        }

        for(char c2: s2.toCharArray()) {
            chars.add(c2);
        }

        String ans = String.valueOf(chars)
                .replace(",", "")  //remove the commas
                .replace("[", "")  //remove the right bracket
                .replace("]", "")  //remove the left bracket
                .replace(" ", "")  //remove space
                .trim();           //remove trailing spaces from partially initialized arrays

        return ans;
    }

    public static String longest2 (String s1, String s2) {
        Set<Character> chars = new TreeSet<>();
        for(char c: (s1 + s2).toCharArray()) {
            chars.add(c);
        }

        String ans = String.valueOf(chars)
                .replaceAll("[\\[\\], ]", "");

        return ans;
    }
}
