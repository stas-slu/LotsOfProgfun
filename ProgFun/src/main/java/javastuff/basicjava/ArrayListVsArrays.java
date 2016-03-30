package javastuff.basicjava;

import java.util.ArrayList;

/**
 * http://java67.blogspot.co.il/2012/12/difference-between-array-vs-arraylist-java.html
 */
public class ArrayListVsArrays {

    /**
     * Main difference between Array vs ArrayList in Java is static nature of Array and dynamic nature of ArrayList
     * You can't create Array without specific size.
     * Once created you can not change size of Array but ArrayList can re-size itself when needed.
     *
     * ArrayList is internally backed by Array in Java, any resize operation in ArrayList will slow down performance
     * as it involves creating new Array and copying content from old array to new array.
     *
     * Also, Array is part of core Java programming and has special syntax and semantics support in Java, while
     * ArrayList is part of Collection framework along with other popular classes e.g. Vector, Hashtable, HashMap or LinkedList.
     */
    public void main (String[] args) {

        /**
         * One more major difference between ArrayList and Array is that, you can not store primitives in ArrayList,
         * it can only contain Objects while Array can contain both primitives and Objects in Java.
         * Though Autoboxing of Java 5 may give you an impression of storing primitives in ArrayList, it actually automatically converts primitives to Object. e.g.
         */
        ArrayList<Integer> integerListArrayList = new ArrayList<>();
        integerListArrayList.add(1); //autoboxing will convert int primitive to Integer object
        integerListArrayList.add(2);
        integerListArrayList.add(3);
        integerListArrayList.add(new Integer(4));

        Integer[] integerListArray = new Integer[10];
        integerListArray[0] = 4;
        integerListArray[1] = 5;
        integerListArray[2] = 6;
        integerListArray[3] = new Integer(7);

        /**
         * You can also compare Array vs ArrayList on How to calculate length of Array or size of ArrayList.
         */
        final int integerListArrayListSize = integerListArrayList.size();
        final int integerListArrayLength = integerListArray.length;

        /**
         * Performance Array and ArrayList provides similar performance in terms of constant time for adding or
         * getting element if you know index.
         * Though automatic resize of ArrayList may slow down insertion a bit Both Array and ArrayList is core concept
         * of Java and any serious Java programmer must be familiar with these differences between Array and ArrayList or in more general Array vs List.
         */
    }
}
