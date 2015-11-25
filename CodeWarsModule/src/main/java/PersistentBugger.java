public class PersistentBugger {

    public static int persistence(long n) {

        int numberOfMultiplications = 0;

        if(Long.toString(n).length() == 1){
            return 0;
        }

        while(true) {
            Integer integer = 1;
            char[] chars = Long.toString(n).toCharArray();

            for(char chr: chars) {
                integer = integer * Character.getNumericValue(chr);
            }

            numberOfMultiplications ++;

            if(integer.toString().length() == 1)
                return numberOfMultiplications;

            n = Long.parseLong(integer.toString());
        }
    }

}
