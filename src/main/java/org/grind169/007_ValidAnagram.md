# Valid Anagram

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length())
            return false;

        int[] temp = new int[26];
        for(int i=0; i<s.length(); i++){
            temp[s.charAt(i)-'a']++;
        }   

        for(int i=0; i<t.length(); i++){
            temp[t.charAt(i)-'a']--;
            if(temp[t.charAt(i)-'a'] < 0){
                return false;
            }
        }

        return true; 
    }
    Time Complexity is O(n)
    Space Complexity is O(1)

Here, char - 'a' results the integer value 'x' which temp[x] means at position 'x', 
increment the value and decrement it in the next loop.

