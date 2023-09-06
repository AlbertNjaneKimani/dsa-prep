package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthOfKDistinctCharcters2 {
    /*
    Solution:
        - We take a Map, which'll give me info about unique characters present, Map key will be character & value will be the occurrence of that character
        - We'll take a max_length variable, where we'll store the solution
        - we'll take two variable start & end, which'll point to 1st character in string initially
        - Now we iterate the string & keep on putting character in map. If size of value is greater than K, then we decrease the character from start index. If occurrence becomes 0, we remove from map.
        - max_length will be updated by end - start + 1
        - At last we return, max_length as answer

        Time Complexity: O(n)
        Space Complexity: O(n)
    * */
    public static int longestLength(String str, int K) {
        if (str == null || str.length() == 0 || str.length()< K){
            return 0;
        }
        int maxLength = 0;
        int start , end;
        start = end =0;
        Map<Character,Integer> map = new HashMap<>();
        while(end < str.length()){
            char currentChar = str.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar,0)+1);
            while(map.size() >K){
                char startchar = str.charAt(start);
                map.put(startchar,map.get(startchar)-1);
                if(map.get(startchar)==0){
                    map.remove(startchar);
                }
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        return maxLength;
    }
    public static void main (String [] args){
        LongestLengthOfKDistinctCharcters2 lon = new LongestLengthOfKDistinctCharcters2();
        int res= lon.longestLength("araaaaci",3);
        System.out.println("len "+ res);
    }
}
//TC: O(N)
//SP: O(N)