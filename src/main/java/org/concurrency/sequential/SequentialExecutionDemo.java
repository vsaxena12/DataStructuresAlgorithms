package org.concurrency.sequential;

public class SequentialExecutionDemo {
        public static void main(String[] args) { //Single thread also called main thread
                demo1();
                demo2();
        }

        private static void demo1(){
                for(int i=0; i<5; i++){
                        System.out.println("From Demo 1: "+i);
                }
        }


        private static void demo2(){
                for(int i=0; i<5; i++){
                        System.out.println("From Demo 2: "+i);
                }
        }
}
