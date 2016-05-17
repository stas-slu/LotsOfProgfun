package basicjava;

public class ByValueAndByReference {

    public static void main( String[] args ){
        Dog aDog = new Dog("Max");
        foo(aDog);

        if (aDog.getName().equals("Max")) { //true
            System.out.println( "Java passes by value." );

        } else if (aDog.getName().equals("Fifi")) {
            System.out.println( "Java passes by reference." );
        }
    }

    public static void foo(Dog d) {
        d.getName().equals("Max"); // true

        d = new Dog("Fifi");
        d.getName().equals("Fifi"); // true
    }

}

class Dog {

    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
