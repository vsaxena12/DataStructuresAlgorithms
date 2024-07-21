package org.data_structures.twoDimensional;

public class TwoDimArray {

    private int[][] arr;

    // Constructor
    // Time complexity: O(mn)
    public TwoDimArray(int numberOfRows, int numberOfColumns){
        this.arr = new int[numberOfRows][numberOfColumns];
        for(int rows = 0; rows < numberOfRows; rows++){
            for(int cols = 0; cols < numberOfColumns; cols++){
                arr[rows][cols] = Integer.MIN_VALUE;
            }
        }

    }

    public void insert(int row, int col, int value){
        // Over all time complexity - O(1)
        // Over all space complexity - O(1)
        try{
            if(arr[row][col] == Integer.MIN_VALUE){
                arr[row][col] = value;
                System.out.println("Value added successfully");
            } else {
                System.out.println("Value already exists");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.err.println("Error: Array out of bound");
        }
    }

    public void accessCell(int row, int col){
        // Overall time complexity: O(1)
        // Overall space complexity: O(1)

        System.out.println("\nAccessing Row# "+row+", Column # "+col);
        try{
            System.out.println("Cell value: " + arr[row][col]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Invalid index for 2D array");
        }
    }

    public void traverse2DArray(){
        // Overall Time complexity: O(mn)
        // Overall Space complexity: O(1)
        for(int row = 0; row < arr.length; row++){   // O(m)
            for(int col = 0; col < arr[0].length; col++){ // O(n)
                System.out.print(arr[row][col]+ " ");
            }
            System.out.print("\n");
        }
    }


    public void searchingIn2DArray(int element){
        // Overall Time complexity: O(mn)
        // Overall Space complexity: O(1)

        for(int row = 0; row < arr.length; row++){   // O(m)
            for(int col = 0; col < arr[0].length; col++){ // O(n)
                if(arr[row][col] == element){
                    System.out.print("\n"+arr[row][col]+ " is found");
                    return;
                }
            }
        }
        System.out.println("\n"+"Value not found");
    }

    public void deletingIn2DArray(int row, int col){
        // Overall Time complexity: O(mn)
        // Overall Space complexity: O(1)
        try{
            System.out.println(arr[row][col]+ " is deleted successfully");
            arr[row][col] = Integer.MIN_VALUE;
        } catch (ArrayIndexOutOfBoundsException e){
            System.err.println("Error: Array is not valid");
        }
    }


    public static void main(String[] args){
        System.out.println("Welcome to 2-D Arrays in Java");
        TwoDimArray twoDimArray = new TwoDimArray(3,3);
        twoDimArray.insert(0,0,10);
        twoDimArray.insert(0,1,20);
        twoDimArray.insert(0,2,30);

        twoDimArray.insert(1,0,23);
        twoDimArray.insert(1,1,34);
        twoDimArray.insert(1,2,45);


        twoDimArray.insert(2,0,50);
        twoDimArray.insert(2,1,60);
        twoDimArray.insert(2,2,70);
        //twoDimArray.accessCell(0,0);
        twoDimArray.traverse2DArray();

        twoDimArray.searchingIn2DArray(200);
        twoDimArray.deletingIn2DArray(0,2);

        twoDimArray.traverse2DArray();
    }
}

//