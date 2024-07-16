package org.data_structures.dev.b.dataStructures.leetcode;

import java.util.Stack;

public class SimplifyPath_71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] str = path.split("/");

        for(String directory: str){
            if(directory.equals(".") || directory.isEmpty()){
                continue;
            } else if(directory.equals("..")){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i=0; i<stack.size(); i++) {
            String dir = stack.get(i);
            result.append("/");
            result.append(dir);
        }

        if(result.length()>0){
            return result.toString();
        } else{
            return "/";
        }
    }

    public static void main(String[] args){
        SimplifyPath_71 simplifyPath = new SimplifyPath_71();
        String output = simplifyPath.simplifyPath("/a/");
        System.out.println(output);
    }
}
