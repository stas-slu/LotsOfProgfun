package certificate.mainmethod;

/**
 * What is the difference?
 *
 * You can't make size() on array, it's for collection!
 */
public class IterationOverMainMethodArgument {

    public static void main(String[] method1) {
        for (int i = 1; i < method1.length && i < 6; i = i + 2)
            System.out.println(method1[i]);
    }

    /*public static void main(String... method2) {
        for (int i = 1; i < method2.size && i < 6; i = i + 2)
            System.out.println(method2[i]);
    }*/
}
