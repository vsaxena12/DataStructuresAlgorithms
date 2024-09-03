package org.lambdas;

import java.util.PriorityQueue;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * Used to provide the implementation of an interface which has functional interface
 * Iterate, filter and extract data from collection
 * Interface which has only one abstract method is called functional interface
 * Java provides an annotation @FunctionalInterface,
 * which is used to declare an interface as functional interface.
 */

interface XYZ {
    void run();
}

/**
 * This is not a functional interface.
 */
abstract class Test {
    abstract void test();

    public void runningTest(){
        //test();
    }

}
public class LambdaExpressionJava {

    public static void main(String[] args) {

        Test test = new Test() {
            @Override
            void test() {
                System.out.println("Running test");
            }
        };

        //test.runningTest();
        test.test();

        XYZ xyz = () -> {
            System.out.println("Running XYZ");
        };
        xyz.run();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
    }
}
