package strings;
import java.util.*;

public class PermutationOfStrings {
    /*
    Given two strings s1 and s2, return true if s2 contains a permutation of s1,
    or false otherwise.
    In other words, return true if one of s1's permutations is the substring of s2.
    * */
    //eg str="bcdcbaba", pattern="abc"
    /*sudo code:
    * Function ifAnagramPresentInString(str, pattern):
    If str is null or empty or pattern is null or empty:
        Return false

    use a hashmap: put all the elements in the  pattern to the hashmap:
    * 1. if element is in the map:
    *     -decrease the frequency of the element in the map
    *     -increase matched element if frequency is greater than or equal to 0
    *     -increase matched element if frequency is greater than or equal to 0
    * 2. when shrinking the window ie removing element from the window:
    *    -increase the frequency of the element in the map
    *    -increase the start
    *    -decreased the matched element.(ie element at start ==0)
*/
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
