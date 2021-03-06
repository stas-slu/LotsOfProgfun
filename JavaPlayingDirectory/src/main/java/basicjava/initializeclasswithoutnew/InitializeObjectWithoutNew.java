package basicjava.initializeclasswithoutnew;

import java.io.IOException;

public class InitializeObjectWithoutNew {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Hello Misie Puaro!");

        //#1
        try {
            ExampleClass exampleClass = ExampleClass.class.newInstance();
            exampleClass.justPrintStuff();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
