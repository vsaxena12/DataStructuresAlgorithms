# Valid Palindrome

## One of the two pointer approach

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if((ch >='a' && ch <= 'z') || 
              (ch >= '0' && ch <= '9')){
                sb.append(ch);
            }
        }
        
        s = sb.toString();

        int i = 0; 
        int j = s.length()-1;

        while(i<j){
            char c1 = s.charAt(i);
            char c2 = s.charAt(j);
            
            if(c1 != c2){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }