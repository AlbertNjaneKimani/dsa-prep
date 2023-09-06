package strings;

import java.util.*;

public class PermutaionsPresentInString {
    //find permutations/anagrams present in a string for a given pattern
    //TC: O(N+M)
    //SP:O(M) where m is characters present in the pattern
    /*   * Function ifAnagramPresentInString(str, pattern):
    If str is null or empty or pattern is null or empty:
        Return false

    use a hashmap: put all the elements in the  pattern to the hashmap:
    * 1. if element is in the map:
    *     -decrease the frequency of the element in the map
    *     -increase matched element if frequency is greater than or equal to 0
    * 2. when shrinking the window ie removing element from the window:
    *    -increase the frequency of the element in the map
    *    -increase the start
    *    -decreased the matched element.(ie element at start ==0)
    *
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
