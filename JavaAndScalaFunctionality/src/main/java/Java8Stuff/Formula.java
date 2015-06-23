package Java8Stuff;

/**
 * Java 8 enables us to add non-abstract method implementations to interfaces by
 * utilizing the default keyword. This feature is also known as Extension Methods.
 *
 * Besides the abstract method calculate the interface Formula also defines the default method sqrt.
 * Concrete classes only have to implement the abstract method calculate. The default method sqrt can be used out of the box.
 *
 * We can use arbitrary interfaces as lambda expressions as long as the interface only contains one abstract method.
 * To ensure that your interface meet the requirements, you should add the @FunctionalInterface annotation.
 * The compiler is aware of this annotation and throws a compiler error as soon as you try to add a second abstract method declaration to the interface.
 */
public interface Formula {

    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}







