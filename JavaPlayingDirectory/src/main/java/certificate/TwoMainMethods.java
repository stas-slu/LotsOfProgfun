package certificate;

/**
 * Will generate two separate .class files!
 *
 * http://stackoverflow.com/questions/4754058/multiple-main-methods-in-java
 */
class FirstClassMultiply {

    public static void main (String args[]){
        System.out.println("Using FirstClassMultiply");
        FirstClassMultiply mult = new FirstClassMultiply();
        System.out.println("Multiple is :" + mult.multiply(2, 4));
    }
    public static void main (int i){
        System.out.println("Using FirstClassMultiply with integer argument");
        FirstClassMultiply mult = new FirstClassMultiply();
        System.out.println("Sum is :" + mult.multiply(2, 5));
    }

    int multiply(int a, int b) {
        return (a * b);
    }
}

class SecondClass {

    public static void main(String args[]) {
        System.out.println("Using SecondClass");

        FirstClassMultiply mult = new FirstClassMultiply();
        System.out.println("Multiply is :" + mult.multiply(2, 3));

        FirstClassMultiply.main(null);
        FirstClassMultiply.main(1);
    }
}