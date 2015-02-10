package javastuff.observerpattern;

public class HexaObserver extends Observer{

    public HexaObserver(SubjectNumValue subjectNumValue){
        this.subjectNumValue = subjectNumValue;
        this.subjectNumValue.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subjectNumValue.getState() ).toUpperCase() );
    }
}
