package org.concurrency.basicMultithreading;

public class ExtendsThreadDemo {
        public static void main(String[] args) {
                Thread one = new ThreadOne();
                Thread two = new ThreadTwo();
                
                one.start();
                two.start();
        }
}


class ThreadOne extends Thread{

        @Override
        public void run(){
                for(int i=0; i<10; i++){
                        System.out.println("From Thread 1: "+i);
                }
        }
}

class ThreadTwo extends Thread{

        @Override
        public void run(){
                for(int i=0; i<15; i++){
                        System.out.println("From Thread 2: "+i);
                }
        }
}