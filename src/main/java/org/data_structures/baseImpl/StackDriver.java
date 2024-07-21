package org.data_structures.baseImpl;

import java.util.Scanner;
public class StackDriver {

    //static StackImpl stackImpl;
    static StackScratchImpl stackImpl;
    public static void runStack(){
        try (Scanner scanner = new Scanner(System.in)) {
            int selectCase;
            do{
                System.out.print("\n1. Push: \n2. Pop: \n3. Peek: \n4. isEmpty: \n5. Size: \n6. Show Stack" +
                        "\nEnter the case you want in Stack: ");
                selectCase = scanner.nextInt();

                switch(selectCase){
                    case 1:
                        System.out.print("Enter the Element to Push: ");
                        stackImpl.push(scanner.nextInt());
                        break;
                    case 2:
                        int poppedElement = stackImpl.pop();
                        System.out.println("Popped Element: "+poppedElement+"\nUpdated Stack: "+stackImpl.givenStack());
                        break;
                    case 3:
                        if(stackImpl.empty()){
                            System.out.println("Stack is empty");
                        }else {
                            int topElement = stackImpl.peek();
                            System.out.println("Find the top element in Stack: " + topElement);
                        }
                        break;
                    case 4:
                        System.out.println("Is Stack Empty: "+stackImpl.empty());
                        break;
                    case 5:
                        int size = stackImpl.size();
                        System.out.println("What is the size of the stack: "+ size);
                        break;
                    case 6:
                        System.out.println("Given Stack: "+stackImpl.givenStack());
                        break;
                }
            }while(selectCase != -1);
        }
    }

    public static void main(String[] args){
        //stackImpl = new StackImpl();
        //runStack();

        stackImpl = new StackScratchImpl();
        runStack();
    }
}
