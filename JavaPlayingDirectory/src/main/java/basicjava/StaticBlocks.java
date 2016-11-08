package basicjava;

import java.util.HashMap;
import java.util.Map;

public class StaticBlocks {

    public static void main (String argc[]) {
        System.out.println("started...");

        StaticBlockClass myClass1 = new StaticBlockClass();

        StaticBlockClass myClass2 = new StaticBlockClass(1);

        System.out.println("finished...");
    }
}


class StaticBlockClass {

    static Map<Double, String> labels1 = new HashMap<>();

    static {
        System.out.println("static block init...");
        Map<Double, String> labels2 = new HashMap<>();
        labels1.put(5.5, "five and a half");
        labels2.put(7.1, "seven point 1");
    }

    public StaticBlockClass() {
        System.out.println("init class...");
        System.out.println("labels1 is " + labels1);
        //System.out.println("labels2 is " + labels2); //can't access it!
    }

    public StaticBlockClass(int param) {
        System.out.println("init class with param " + param + "...");
    }
}


