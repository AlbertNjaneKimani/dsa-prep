package strings;

import java.util.*;

public class SmallestSubstringWithAllPatternCharacters {
    /*
    Solution:
        - We create a map of frequency of characters present in pattern
        - Now we start from 1st index & if that character present in map,
          then we decrease the frequency by 1 & we check if the frequency is greater than 0,
          then we increase the matchedElement variable by 1
        - If matchedElement becomes equal to size of pattern then we've found our anagram
          & we store minimum length & starting point at this moment
        - Now we increase start & go until matchedElement is equal to pattern size.
          At every moment we update the starting point & min length if end - start + 1 is less than minLength
        - Now if any element is moving out of window, we check if it's part of map,
          then increase the frequency by 1 & if the frequency is 0 then decrease the matchedElement by 1
        - At last, we return substring starting from subStringStartIndex to subStringStartIndex + minLength
        Time Complexity: O(n + m)
        Space Complexity: O(m)
    * */
    public static String findSmallestLength(String str, String pattern) {
        if (str.length() == 0 || str == null || pattern.length() == 0 || pattern == null) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        int matchedCharacter = 0;
        int start = 0;
        int minSubstringLength = Integer.MAX_VALUE;
        int minSubstringStart = 0;
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        for (int end = 0; end < str.length(); end++) {
            char currentChar = str.charAt(end);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) >= 0) {
                    matchedCharacter++;
                }
            }
            while (matchedCharacter == pattern.length()) {
                if (end - start + 1 < minSubstringLength) {
                    minSubstringLength = end - start + 1;
                    minSubstringStart = start;
                }
                //we want to slide the window. increment char at start and check if
                //the charcter is present in the map and increment its frequency
                // and decrease matchedCharacter if map frequency for that character is 0
                char charAtStart = str.charAt(start++);
                if (map.containsKey(charAtStart)) {
                    if (map.get(charAtStart) == 0) {
                        matchedCharacter--;
                    }
                    map.put(charAtStart, map.get(charAtStart) + 1);
                }
            }
        }
        if (minSubstringLength > str.length()) {
            return "";
        }
        return str.substring(minSubstringStart, minSubstringStart + minSubstringLength);
    }

    public static void main(String[] args) {
        SmallestSubstringWithAllPatternCharacters ss = new SmallestSubstringWithAllPatternCharacters();
        String str = "badeaebcaae";
        String pattern = "aabc";
        String res = ss.findSmallestLength(str, pattern);
        System.out.println(res);
        //TC:O(N+M)
        //SP:O(M)
    }
}
