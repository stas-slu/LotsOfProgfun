package basicjava;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * http://stackoverflow.com/questions/11559954/internals-of-how-the-hashmap-put-and-get-methods-work-basic-logic-only
 *
 * http://www.xyzws.com/javafaq/why-always-override-hashcode-if-overriding-equals/20
 */
public class EqualsAndHashCodeContractInMaps {

    public static void main(String[] argc) {
        MyClass firstKey = new MyClass("a", "firstText");
        MyClass secondKey = new MyClass("a", "secondText");

        Map<MyClass, String> myMap = new HashMap<>();
        myMap.put(firstKey, "value 1");
        myMap.put(secondKey, "value 2");

        System.out.println("firstKey.equals(secondKey): " + firstKey.equals(secondKey));
        System.out.println("firstKey.hashCode() == secondKey.hashCode(): " + String.valueOf(firstKey.hashCode() == secondKey.hashCode()));
        System.out.println("Map size: " + myMap.size());
        System.out.println("myMap.get(firstKey): " + myMap.get(firstKey));
        System.out.println("myMap.get(secondKey): " + myMap.get(secondKey));
        System.out.println("Map: " + myMap);
    }
}

class MyClass {

    private final String importantField;
    private final String anotherField;

    public MyClass(final String equalField, final String anotherField) {
        this.importantField = equalField;
        this.anotherField = anotherField;
    }

    /**
     * If hashCode() NOT override (and equals() does), the hashCode() for two even identical element, will not be the
     * same!
     *
     * new MyClass("a","text").hashCode() != new MyClass("a","text").hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((importantField == null) ? 0 : importantField.hashCode());
        return result;
    }

    /**
     * If equals() NOT override and hashCode() does, it means that for equal hashCode(), twp different objects
     * would enter the same bucket. So we traverse through linked list of key/values for the same key, comparing
     * keys with equals() to find the specific key/value to get updated.
     * And, without equals(), we won't succeed to compare the key!
     */
    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final MyClass other = (MyClass) obj;
        if (importantField == null) {
            if (other.importantField != null)
                return false;
        } else if (!importantField.equals(other.importantField))
            return false;
        return true;
    }
}
