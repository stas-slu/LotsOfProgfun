import java.util.regex.Pattern;

public class IdentifierChecker {

    /**
     * Each identifier must have at least one character.
     The first character must be picked from: alpha, underscore, or dollar sign. The first character can not be a digit.
     The rest of the characters (besides the first) can be from: alpha, digit, underscore, or dollar sign. In other words, it can be any valid identifier character.
     */
    public static boolean isValid(String idn) {
        if(idn.length() == 0)
            return false;

        final char[] chars = idn.toCharArray();
        final char firstChar = chars[0];

        if(isAplhaUnderscoreOrDollar(firstChar)){
            for (char chr : chars){
                if(!(Character.isDigit(chr) || isAplhaUnderscoreOrDollar(chr))){
                    return false;
                }
            }

        } else {
            return false;
        }

        return true;
    }

    private static boolean isAplhaUnderscoreOrDollar(char chr) {
        return Character.isLetter(chr) || chr == '_' || chr == '$';
    }

    public static boolean isValidSmarter(String idn) {
        final Pattern idPattern = Pattern.compile("[a-zA-z_$][a-zA-z_$0-9]*");

        return !(idn == null || idn.isEmpty()) && idPattern.matcher(idn).matches();
    }
}