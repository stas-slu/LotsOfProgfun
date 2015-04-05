package main.java.javastuff.observerpattern;

public class ObserverPatternDemo {
    public static void main(String[] args) {
        SubjectNumValue subjectNumValue = new SubjectNumValue();

        new HexaObserver(subjectNumValue);
        new OctalObserver(subjectNumValue);
        new BinaryObserver(subjectNumValue);

        System.out.println("$$$$$ First state change: 15");
        subjectNumValue.setState(15);
        System.out.println("$$$$$ Second state change: 10");
        subjectNumValue.setState(10);
    }
}
