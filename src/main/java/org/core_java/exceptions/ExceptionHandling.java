package org.core_java.exceptions;

public class ExceptionHandling {


    public static void main(String[] args) {
        @SuppressWarnings("unused")
        int i = 10;
//        if(i == 10){
//            throw new ArithmeticException("");
//        }

        try{

        } catch(Exception e){
            throw new ArithmeticException("");
        }
        System.out.println("Hello");
    }
}
