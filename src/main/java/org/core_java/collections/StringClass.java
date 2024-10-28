package org.core_java.collections;

import java.util.Arrays;

/**
 * String is fundamental class used for handling sequences of characters.
 */
class StringClass {
    public static void strings() {
        System.out.println("\n--------- String Class ---------");
        System.out.println("\n--------- Strings ---------");

        //Using string literal
        String strLiteral = "Hello World";

        //Using string object
        String stringObject = new String("Hello World");
        System.out.println(stringObject);

        //s1.isEquals(s2);
        boolean isTwoStringsEqual = stringObject.equals(strLiteral);
        System.out.println(isTwoStringsEqual); //true

        //s1.equalsIgnoreCase(s2);


        //return length of the string
        int stringLength = stringObject.length();
        System.out.println(stringLength);

        int index = 0;
        char ch = strLiteral.charAt(index);
        System.out.println("Element at index 0: "+ch);

        char[] charArray = strLiteral.toCharArray();
        System.out.println("Elements : "+ Arrays.toString(charArray));

        String substr = stringObject.substring(5);
        System.out.println("Substring from begin: "+substr);

        substr = strLiteral.substring(3, stringLength);
        System.out.println("Substring from begin to given index end: "+substr);

        int num = strLiteral.compareTo("Hello");
        System.out.println("Comparison result : "+num);
        num = strLiteral.indexOf("ello");
        System.out.println("IndexOf result : "+num);//e
        //s1.lastIndexOf(element);

        String s1 = "IotaDelta";
        boolean containsIoD = s1.contains("taD");
        System.out.println(containsIoD);


        //str.toUpperCase();
        //str.toLowerCase();
        //str.split(",");
        //str.replace("World", "Java");

        //String.valueOf(123);
        //Arrays.toString("Element");

    }

    public static void stringBuilder() {
        System.out.println("\n--------- String Builder ---------");

        StringBuilder builder = new StringBuilder();
        builder.append("Hello World");
        builder.append("!");
        builder.append("!");
        builder.append("!");
        System.out.println(builder.toString());

        //Insert String
        String s = builder.insert(3, "gaya").toString();
        System.out.println("Insert: "+s);

        //Replace String
        s = builder.replace(3, 4,"kayak").toString();
        System.out.println("Replace: "+s);

        s = builder.delete(5,7).toString();
        System.out.println("Delete: "+s);

        s = builder.deleteCharAt(5).toString();
        System.out.println("DeleteCharAt: "+s);

        s = builder.reverse().toString();
        System.out.println("Reverse: "+s);

        //builder.capacity();
        //builder.ensureCapacity(100);
        //builder.length();
        //builder.setLength(5);

    }
}


