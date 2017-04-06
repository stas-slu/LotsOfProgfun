package certificate;

/**
 * Will generate two separate .class files!
 *
 * http://stackoverflow.com/questions/4754058/multiple-main-methods-in-java
 */
public class TwoMainMethods {

    public static void main (String args[]){
        System.out.println("Using TwoMainMethods");
        TwoMainMethods mult = new TwoMainMethods();
        System.out.println("Multiple is :" + mult.multiply(2, 4));
    }
    public static void main (int i){
        System.out.println("Using TwoMainMethods with integer argument");
        TwoMainMethods mult = new TwoMainMethods();
        System.out.println("Sum is :" + mult.multiply(2, 5));
    }

    int multiply(int a, int b) {
        return (a * b);
    }
}

class SecondClass {

    public static void main(String args[]) {
        System.out.println("Using SecondClass");

        TwoMainMethods mult = new TwoMainMethods();
        System.out.println("Multiply is :" + mult.multiply(2, 3));

        TwoMainMethods.main(null);
        TwoMainMethods.main(1);
    }
}