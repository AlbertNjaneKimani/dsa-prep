package strings;
import java.util.*;

public class PermutationOfStrings {
    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1,
    or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.
    Solution:
    - We create a map of frequency of characters present in pattern
    - Now we start from 1st index & if that character present in map,
     then we decrease the frequency by 1 & we check if the frequency now becomes 0,
     then we increase the matchedElement variable by 1
    - If matchedElement becomes equal to size of map or unique characters in pattern
      then we've found our anagram
      & we return true
    - Now if any element is moving out of window, we check if it's
      part of map, then increase the frequency by 1 & if the frequency is 0
      then decrease the matchedElement by 1
    - At last, if there's no match found, then we return false

    Time Complexity: O(n + m)
    Space Complexity: O(m)
    * */


    public static boolean isAnagramPattern(String str, String pattern){
        if(str.length() == 0 || str == null || pattern == null || pattern.length()==0){
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        //insert the elements in the pattern in the map
        for(int i = 0; i < pattern.length(); i++){
            map.put(pattern.charAt(i),map.getOrDefault(pattern.charAt(i),0)+1);
        }
        int matchedElement = 0;
        int start =0;
        for(int i = 0; i<str.length(); i++){
            char currentChar = str.charAt(i);
            if(map.containsKey(currentChar)){
                map.put(currentChar, map.get(currentChar)-1);
                if(map.get(currentChar)==0){
                    matchedElement++;
                }
            }
            if(map.size() == matchedElement){
                return true;
            }
            //i want to shrink the window size ie incrementing the start.
            if(i >=pattern.length()-1){
               char charStart = str.charAt(start++);
               if(map.containsKey(charStart)){
                   if(map.get(charStart)==0){
                       matchedElement--;
                   }
                   map.put(charStart,map.get(charStart)+1);
               }
            }

        }
        return false;
    }
    public static void main(String [] args){
        PermutationOfStrings ps = new PermutationOfStrings();
        boolean res = ps.isAnagramPattern("bcdcbaba","abc");
        System.out.println(res);
    }
    //TC: O(N+M)
    //SP:O(M) where m is pattern characters
}
