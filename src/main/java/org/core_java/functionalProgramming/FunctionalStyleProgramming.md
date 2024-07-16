# Functional Programming

## Benefits:
- Compact and efficient code
- Exploiting parallelism

## Method args:
    before Java 8
        - Primitives and object references
    after Java 8
        - Behaviour

## History: 
    lambda calculas functions -> anonymous
        λx.x*x
        λx is the argument and x*x is the body


## What is Lambda? 

Anonymous function

Compact way to define functions and pass around function
    
    (type parameter1, type parameter2, ...) -> {
        //Statements1 .....
        return something;
    }

functional interface variable <- λ

    E.g. 
    Set<String> set = new TreeSet<String>(new Comparator<String>(){
        public int compare(String s1, String s2) {
            return s1.length() - s2.length();
        }
    })

    Set<String> set = new TreeSet<String>((s1, s2) -> s1.length() - s2.length());
    Here, new Comparator<>() is a functional interface, if not it will throw error. 
    
Some other examples:
    
    () -> {}
    (Book b) -> { System.out.println(b.getTitle()); }
    (Book b) -> { return b.rating() >= 4.5; }
    (Book b) -> b.rating() >= 4.5
    b -> b.rating() >= 4.5
    () -> "java"  //Not () -> { "java"; } (not statement)
    () -> { return "java"; } //Not () -> return "java"; (not expression)

Anonymous Class

    - Has associated object 
        - Verbose
    - Instantiated on every use (unless decalred as singleton)
    - Target type (class/interface) can have mulitple methods

Lambdas
    
    - No associated object (invoked dynamic) + compact representation
    - Memory allocated only once for method
    - Works with only functional interfaces

# Functional Interface in Java

What is a Functional Interface?
A functional interface in Java is an interface that contains exactly one abstract method. 
These interfaces can contain multiple default or static methods, but only one abstract method. 
Functional interfaces are intended to represent a single functionality contract and can be used as the assignment target for lambda expressions or method references.

Key Characteristics

	•	Single Abstract Method: Functional interfaces have only one abstract method.
	•	@FunctionalInterface Annotation: Although not mandatory, it is a good practice to annotate a functional interface with @FunctionalInterface. This annotation is informative and also helps the compiler to enforce that the interface has only one abstract method.
	•	Default and Static Methods: Functional interfaces can contain multiple default or static methods.

Examples of Functional Interfaces

Java provides several built-in functional interfaces in the java.util.function package, such as:

	•	Predicate<T>: Represents a predicate (boolean-valued function) of one argument.
	•	Function<T, R>: Represents a function that takes one argument and produces a result.
	•	Consumer<T>: Represents an operation that accepts a single input argument and returns no result.
	•	Supplier<T>: Represents a supplier of results.

Custom Functional Interface Example

Here’s how you can define and use a custom functional interface:

Step 1: Define a Functional Interface

    @FunctionalInterface
    public interface MyFunctionalInterface {
    // Single abstract method
    void execute();
    
        // Default method
        default void defaultMethod() {
            System.out.println("This is a default method.");
        }
        
        // Static method
        static void staticMethod() {
            System.out.println("This is a static method.");
        }
    }

Step 2: Implement the Functional Interface Using Lambda Expression

    public class Main {
        public static void main(String[] args) {
            // Implementing the functional interface using a lambda expression
            MyFunctionalInterface myFuncInterface = () -> {
                System.out.println("Executing the functional interface method.");
            };
            
            // Calling the abstract method
            myFuncInterface.execute();
            
            // Calling the default method
            myFuncInterface.defaultMethod();
            
            // Calling the static method
            MyFunctionalInterface.staticMethod();
        }
    }

Using Built-In Functional Interfaces

Example with Predicate

    import java.util.function.Predicate;
    public class Main {
        public static void main(String[] args) {
            Predicate<String> isLongerThanFive = s -> s.length() > 5;
    
            System.out.println(isLongerThanFive.test("Hello")); // Output: false
            System.out.println(isLongerThanFive.test("Hello, World!")); // Output: true
        }
    }

Example with Function

    import java.util.function.Function;

    public class Main {
        public static void main(String[] args) {
            Function<Integer, String> intToString = i -> "The number is " + i;
    
            System.out.println(intToString.apply(5)); // Output: The number is 5
        }
    }

Conclusion

A functional interface in Java is a powerful feature that allows you to use lambda expressions and method references, 
making your code more concise and readable. By understanding and utilizing functional interfaces, you can take full 
advantage of Java’s functional programming capabilities.


# Predicate and Function 

In Java, Predicate and Function are part of the java.util.function package and are used to represent functional interfaces. These interfaces can be used as the target types for lambda expressions and method references, enabling functional programming in Java.

## Predicate

A Predicate is a functional interface that represents a single argument function that returns a boolean value. 
It is commonly used for filtering or matching conditions.

    import java.util.function.Predicate;
    
    public class Main {
        public static void main(String[] args) {
            // Predicate to check if a string's length is greater than 5
            Predicate<String> isLongerThanFive = s -> s.length() > 5;
            
            // Test the predicate with different strings
            System.out.println(isLongerThanFive.test("Hello")); // Output: false
            System.out.println(isLongerThanFive.test("Hello, World!")); // Output: true
        }
    }

## Function

A Function is a functional interface that represents a function which takes one argument and produces a result. 
It is commonly used for transforming or mapping operations.

    import java.util.function.Function;
    public class Main {
        public static void main(String[] args) {
            // Function to convert an integer to a string with a specific format
            Function<Integer, String> intToString = i -> "The number is " + i;
            
            // Apply the function to different integers
            System.out.println(intToString.apply(5)); // Output: The number is 5
            System.out.println(intToString.apply(10)); // Output: The number is 10
        }
    }


