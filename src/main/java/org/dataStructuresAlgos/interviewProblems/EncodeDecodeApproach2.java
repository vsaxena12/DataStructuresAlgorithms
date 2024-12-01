package org.dataStructuresAlgos.interviewProblems;

//import org.checkerframework.checker.units.qual.N;

import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeApproach2 {

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<strs.size(); i++){
            sb = sb.append(strs.get(i));
            sb = sb.append(nonASCII());
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        ArrayList<String> list = new ArrayList<>();

        String[] decodedStrings = s.split(nonASCII(),-1);
        for(int i=0; i<decodedStrings.length-1; i++){
            list.add(decodedStrings[i]);
        }
        //List list = Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1);
        //return new ArrayList<>(list);
        return list;
    }

    public static void main(String[] agrs){
        List<String> str = new ArrayList<>();
//        str.add("@JrgRy=r*Y*rpG4mur0.mL7tTd");
//        str.add("VFFlw8ooB2:/`FYFffJ_[(A`)M*qS`ObgIB`F=~?Y.e4Lc|d)mFU=");
//        str.add("d*-x%zqFopY`-c?z^ CA&%aoR{$?LWi=*RS?IC {x;Lkq6Wdz4I$|lx9U3)ieuy(H5t9-?4cK(Yc?=aM); N.");
//        str.add("N;TthQ+h[=o.@]?YXo2hnRFln=AGV}a/]_t>l4}^9a8vx/_}+4z1wd~Lo,yN7OB <3 ;7hOL:QS>__");
//        str.add("0$35s)]#:Bds!p4^raa+_]mgt$xw+.:k&Mu 5%1x6M8L");
//        str.add("vVgU425");
//        str.add("woWv(o}+P*!");

        str.add("Hello");
        str.add("World");
        System.out.println("Encode String: "+encode(str));
        System.out.println("Encode String: "+decode(encode(str)));

//        Starting from 128 (0x80) to include non-ASCII characters only
//        for (char c = 1; c <= 3000; c++) {
//            System.out.println(c);
//        }

    }

    private static String nonASCII(){
        char s = 3000;
        return String.valueOf(s);
    }
}