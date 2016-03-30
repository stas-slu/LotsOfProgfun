package basicjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionsPlaying {

    public static void main(String[] argc){
        listRetain();
        mutableLists();
    }

    private static void listRetain() {
        /**
         * The retain will leave list of 2,2,2,2. WITH DUPLICATE.
         */
        List<Integer> ints1 = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 5, 5));
        List<Integer> ints2 = new ArrayList<>(Arrays.asList(2, 2, 103));
        List<Integer> ints3 = new ArrayList<>(Arrays.asList(2, 431));
        ints1.retainAll(ints2);
        ints1.retainAll(ints3);
        /**
         * To overcome duplication, we can use some SET
         */
        final Integer[] myNums1 = new Integer[]{2, 2, 103};
        final Integer[] myNums2 = new Integer[]{2, 431};
        Set<Integer> ints4 = new HashSet<>(Arrays.asList(2, 2, 2, 2, 5, 5));
        Set<Integer> ints5 = new HashSet<>(Arrays.asList(myNums1));
        Set<Integer> ints6 = new HashSet<>(Arrays.asList(myNums2));
        ints4.retainAll(ints5);
        ints4.retainAll(ints6);
    }

    private static void mutableLists() {
        List<Integer> ints1 = new ArrayList<>();
        ints1.add(new Integer(1));
        ints1.add(new Integer(2));

        List<Integer> ints2 = new ArrayList<>(Arrays.asList(4, 5, 6));
        ints2.add(new Integer(4));

        List<Integer> ints3 = Arrays.asList(4, 5, 6);
        // Will fail, Arrays.asList creates immutable! In previous example we passed it as constructor so
        // It will create a ordinary mutable List
        ints3.add(new Integer(4));

        List<Integer> ints1Immutable = Collections.unmodifiableList(ints1);
        // Will fail as well. Now unmodifiable.
        ints1Immutable.add(new Integer(4));
    }
}
