package org.dataStructuresAlgos.strings;

public class StringInJava {
    // String s = 'A man, a plan, a canal: Panama";
    // s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    // "amanaplanacanalpanama"
    static void str(){
        /**
         * Strings are the type of objects that can store the character of values and in Java,
         * every character is stored in 16 bits i,e using UTF 16-bit encoding.
         * A string acts the same as an array of characters in Java.
         */
        String name = "Geeks"; //String literal -> make Java more memory efficient
        // because no new objects are created if it exists already in the string constant pool.


        String demoString = new String("Geeks"); // JVM will create a new string object in normal heap memory
        //Variable demoString will refer to the object in the heap

        /**
         * Hence, name is not equal to demoString if(name == demoString)
         * But, is equal if(name.equals(demoString)
         */
        if(name != demoString){
            System.out.println(false);
        }
        if(name.equals(demoString)){ //equalsIgnoreCase
            System.out.println(true);
        }

        //Important Java String Methods
        String s = "A man, a plan, a canal: Panama";
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // "amanaplanacanalpanama"

        System.out.println("Length of the String: "+s.length()); //Returns the number of characters in the String.

        //Char charAt(int i)
        System.out.println("Get Character At: "+s.charAt(3)); //Returns the character at ith index.

        //String substring (int i)
        System.out.println("Get substring from: "+s.substring(3)); //Return the substring from the ith  index character to end.

        //String substring (int i, int j)
        System.out.println("Get substring from i to j-1: "+s.substring(3, 7)); //Returns the substring from i to j-1 index.

        //String concat( String str)
        String s1 = "Geeks";
        String s2 = "forGeeks"; // Concatenates specified string to the end of this string.
        String output = s1.concat(s2); // returns “GeeksforGeeks”
        System.out.println("Returns 'GeeksforGeeks':  "+output);

        String cases = "HeLLo";
        System.out.println("To LowerCase: "+cases.toLowerCase());
        System.out.println("To UpperCase: "+cases.toUpperCase());

        String trimWhiteSpaces = " Learn To Share ";
        System.out.println("To Trim(): '"+trimWhiteSpaces.trim()+"'"); //Returns the copy of the String, by removing whitespaces at both ends. It does not affect whitespaces in the middle

        @SuppressWarnings("unused")
        String str1 = "feeksforfeeks";
        @SuppressWarnings("unused")
        String str2 = "feeksforfeeks".replace('f' ,'g'); // returns “geeksforgeeks”


        str1="geeksforgeeks";
        str2="geeks";
        s1.contains(s2); // return true

        String string1="geeksforgeeks"; //Converts this String to a new character array.
        @SuppressWarnings("unused")
        char []ch=string1.toCharArray();  // returns [ 'g', 'e' , 'e' , 'k' , 's' , 'f', 'o', 'r' , 'g' , 'e' , 'e' , 'k' ,'s' ]

        //toString();
        //String.valueOf(val);
        //Integer.parseInt(str); etc...


    }
    public static void main(String[] args){
        str();
    }
}
