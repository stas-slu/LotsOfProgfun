package javastuff.observerpattern;

public class OctalObserver extends Observer {

    public OctalObserver(SubjectNumValue subjectNumValue) {
        this.subjectNumValue = subjectNumValue;
        this.subjectNumValue.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subjectNumValue.getState()));
    }
}
