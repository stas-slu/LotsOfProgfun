package basicjava;

import java.util.HashMap;
import java.util.Map;

public class CastingGames {
    /**
     * Playing with casting.
     * Casting == taking an Object of one particular type and “turning it into” another Object type
     *
     * https://howtoprogramwithjava.com/java-cast/
     */
    public static void main(String args[]) {

        /**
         * Downcast.
         * Taking Object and casting it into a more “specific” type of Object.
         *
         * IT'S *NOT* ALWAYS SAFE TO DOWNCAST!
         * There is a certain amount of risk that goes along with downcasting your variables. If you were to try to
         * cast something like a Date object to an Integer object, then you’ll get a ClassCastException.
         * This is what’s known as a run-time exception, as it’s really only detectable when your code is running.
         */
        Object aSentenceObject1 = "This is just a regular sentence";
        String aSentenceString1 = (String) aSentenceObject1;

        /**
         * Upcast.
         * Taking variable with a specific type (String) and casting it to a variable type that’s more generic (Object).
         *
         * IT'S ALWAYS LEGAL TO UPCAST.
         */
        String aSentenceString2 = "This is just another regular sentence";
        Object aSentenceObject2 = (Object) aSentenceString2;

        /**
         * It'sa valuable approach to storing Objects in a Map, because if we had created the Map with something more
         * specific than Object as the value, then we would be constrained to only storing Objects of that specific
         * type.
         */
        Map<String, Object> model = new HashMap<>(); //String -> Object!
        model.put("name", "Stas Page");
        model.put("email", "test@stas.com");
        model.put("birthday", 07-01-83);

        String name = (String) model.get("name");
        String email = (String) model.get("email");
        int birthday = (int) model.get("birthday");
    }
}
