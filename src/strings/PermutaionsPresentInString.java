package strings;

import java.util.*;

public class PermutaionsPresentInString {
    //find permutations/anagrams present in a string for a given pattern
    //TC: O(N+M)
    //SP:O(M) where m is characters present in the pattern
    /*
    Solution:
        - We create a map of frequency of characters present in pattern
        - Now we start from 1st index & if that character present in map, then we decrease the frequency by 1 & we check if the frequency now becomes 0, then we increase the matchedElement variable by 1
        - If matchedElement becomes equal to size of map or unique characters in pattern then we've found our anagram & we add starting index in final List
        - Now if any element is moving out of window, we check if it's part of map, then increase the frequency by 1 & if the frequency is 0 then decrease the matchedElement by 1
        - At last, we return list containing all starting indexes, where we get anagrams

        Time Complexity: O(n + m)
        Space Complexity: O(m)
*/
    public static List<Integer> getAllAnagrams(String str, String pattern) {
        if (str == null || str.length() == 0 || pattern == null || pattern.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), map.getOrDefault(pattern.charAt(i), 0) + 1);
        }
        int matchedElement = 0;
        int start = 0;
        List<Integer> anagramIndexes = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (map.containsKey(currentChar)) {
                map.put(currentChar, map.get(currentChar) - 1);
                if (map.get(currentChar) == 0) {
                    matchedElement++;
                }
            }
            if (matchedElement == map.size()) {
                anagramIndexes.add(start);
            }
            if(i>=pattern.length()-1){
                char charAtStart = str.charAt(start++);
                if(map.containsKey(charAtStart)){
                    if(map.get(charAtStart)==0){
                        matchedElement--;
                    }
                    map.put(charAtStart, map.get(charAtStart)+1);
                }
            }
        }
        return anagramIndexes;
    }
    public static void main(String []args){
        String str ="bcdcbabcbd";
        String pattern ="abc";
        PermutaionsPresentInString ps = new PermutaionsPresentInString();
        List<Integer>res = ps.getAllAnagrams(str,pattern);
        System.out.println(res);
    }
    //TC: O(N+M)
    //SP: O(M)
}
