package strings;

import java.util.*;

public class LongestSubstringWithSameLettersAfterKReplacements {
    //find the longest substring with same letter if "K" characters can be replaced
    // str ="bccbababd", k =2, output = 5
    /*
    Solution:
        - We iterate each character one by one & add into map & increase the frequency by one
        - We also maintain maxFrequency for any letter
        - We update maxLength as end - start + 1
        - Now at every iteration, we check if end - start + 1 - maxFrequency is greater than k,
          then we need to remove it from map so we decrease the frequency by 1
        - At last, we return maxLength

        Time Complexity: O(n), where n is number of characters in String
        Space Complexity: O(1)
    * */
    public static int longestLength(String str, int k) {
        if (str == null || str.length() == 0 || k <= 0 || k > str.length()) {
            return -1;
        }
        int maxLength = 0;
        int start, end;
        start = end = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(end < str.length()){
            char currentChar = str.charAt(end);
            map.put(currentChar, map.getOrDefault(currentChar,0)+1);
            maxFreq = Math.max(maxFreq, map.get(currentChar));
            if(end - start +1 -maxFreq > k){
                char startChar = str.charAt(start);
                map.put(startChar, map.get(startChar)-1);
                start++;
            }
            maxLength = Math.max(maxLength, end - start +1);
            end ++ ;
        }
        return maxLength;
    }
    public static void main(String [] args){
        LongestSubstringWithSameLettersAfterKReplacements ls = new LongestSubstringWithSameLettersAfterKReplacements();
        int result = ls.longestLength("bccbababd",2);
        System.out.println(result);
        //TC : O(N)
        //SP: O(N)
        //SP: O(26)->O(1) since we have 26 unique characters
    }
}
