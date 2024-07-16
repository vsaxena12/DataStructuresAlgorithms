package org.data_structures.dev.b.dataStructures.bitManipulation.preReq;

public class NumberToBit {

    private static String decimalToBinary(int n){
        String s = "";
        int x;
        while(n>=1){
            x = n%2;
            s = x + s;
            n = n/2;
        }

        return s;
    }

    private static int binaryToDecimal(String b) {
        int result = 0;
        int powOf2 = 1;

        for(int i=b.length()-1; i>=0; i--){
            if(b.charAt(i) == '1'){
                result = result + powOf2;
            }
            powOf2 = powOf2 * 2;
        }
        return result;
    }

    public static void print(){
        String bitValue = decimalToBinary(45);
        System.out.println(bitValue);
        int DecimalValue = binaryToDecimal(bitValue);
        System.out.println(DecimalValue);
    }


}
