package main.java.javastuff.observerpattern;

public class BinaryObserver extends Observer{

    public BinaryObserver(SubjectNumValue subjectNumValue){
        this.subjectNumValue = subjectNumValue;
        this.subjectNumValue.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subjectNumValue.getState() ) );
    }
}
