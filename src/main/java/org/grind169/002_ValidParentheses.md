# Valid Parenthesis

An input string is valid if:

- Open brackets must be closed by the same type of brackets.
- Open brackets must be closed in the correct order.
- Every close bracket has a corresponding open bracket of the same type.

Here, we use Stack with the code mentioned below: 

    public boolean isValid(String s) {
        if(s.length() == 0 || s == null){
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if((!stack.isEmpty()) && ((stack.peek() == '(' && ch == ')') || 
               (stack.peek() == '{' && ch == '}') ||
               (stack.peek() == '[' && ch == ']'))){

                stack.pop();

            }else{
                stack.push(ch);
            }
        }


        if(stack.isEmpty()){
            return true;
        } else{
            return false;
        }
    }