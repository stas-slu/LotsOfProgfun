import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * http://www.codewars.com/kata/558878ab7591c911a4000007/train/java
 */
public class SingleWordPigLatin {


    public String translate(String str){
        if (anyAlphaChars(str)) {
            return null;
        }

        str = str.toLowerCase();

        if (wordStartsWithVowel(str)) {
            str = str + "way";
        } else if (wordStartWithConsonant(str)) {
            str = moveConsonantsToEnd(str) + "ay";
        } if (wordHasNoVowels(str)) {
            str = str + "ay";
        }
        return str;
    }

    private String moveConsonantsToEnd(String str) {
        int charsToMove = howManyCharsToMove(str);
        return str.substring(charsToMove) + str.substring(0, charsToMove);
    }

    private int howManyCharsToMove(String str) {
        int counter = 0;
        for(Character chr : str.toCharArray()) {
            if(isCharVowel(chr)) {
                return counter;
            }
            counter++;
        }
        return counter;
    }

    private boolean wordStartWithConsonant(String str) {
        return !wordStartsWithVowel(str);
    }

    private boolean wordHasNoVowels(String str) {
        for(Character chr : str.toCharArray()) {
            if(isCharVowel(chr)) {
                return false;
            }
        }
        return true;
    }

    private boolean wordStartsWithVowel(String str) {
        return isCharVowel(str.charAt(0));
    }

    private boolean isCharVowel(Character toCheck) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'o', 'i', 'e', 'u'));
        return vowels.contains(toCheck);
    }

    private boolean anyAlphaChars(String str) {
        for(Character chr : str.toCharArray()) {
            if(!Character.isAlphabetic(chr)) {
                return true;
            }
        }
        return false;
    }
}
