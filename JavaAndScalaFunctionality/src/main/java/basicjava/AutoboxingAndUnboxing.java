package basicjava;

import java.util.ArrayList;

public class AutoboxingAndUnboxing {

    public static void main (String[] argc) {
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1); //autoboxing - primitive to object
        intList.add(2); //autoboxing - primitive to object
        intList.add(new Integer(3)); //not autoboxing. we made the boxing (turn primitive to object)!

        ThreadLocal<Integer> intLocal = new ThreadLocal<>();
        intLocal.set(4); //autoboxing - primitive to object
        intLocal.set(new Integer(5)); //not autoboxing. we made the boxing (turn primitive to object)!

        Integer num1 = 6; //boxing
        int num2 = num1 + 7; // //unboxing, object to primitive

        int number = intList.get(0); //unboxing in Java (turn object to primitive)
        int local = intLocal.get(); // unboxing in Java (turn object to primitive)

        /**
         * Before autoboxing in Java 1.5 and after
         */

        //before java5
        Integer numberObjectA = Integer.valueOf(3); //boxing
        int numberPrimitiveA = numberObjectA.intValue(); //unboxing

        //after java5
        Integer numberObjectB = 3; //autoboxing (primitive to object)
        int numberPrimitiveB = numberObjectB; //unboxing (object to primitive)
    }
}
