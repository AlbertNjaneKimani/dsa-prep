package strings;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
    //find the longest substring without repeating characters
/*sudo code: Function longestSubstringWithoutRepeatingCharacters(inputString):
    If inputString is empty or null:
        Return -1

    Initialize maxLength to 0
    Initialize start and end pointers to 0
    Initialize an empty HashMap (characterMap) to store characters and their indices

    While end < length(inputString):
        currentChar = inputString[end]

        If currentChar is in characterMap:
            Move the start pointer to max of (start, characterMap[currentChar] + 1)

        Update characterMap[currentChar] to end

        Calculate currentLength as (end - start + 1)

        Update maxLength to max of (maxLength, currentLength)

        Increment end pointer by 1

    Return maxLength*/
    public static int longestLength(String str) {
        if(str.length()==0 || str == null){
            return -1;
        }
        int maxLength = 0;
        int start, end;
        start = end = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < str.length()) {
            char currentChar = str.charAt(end);
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            map.put(currentChar, end);
            maxLength = Math.max(end - start + 1, maxLength);
            end++;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        int result = ls.longestLength("brttstauu");
        System.out.println(result);
    }
    //Tc : O(N)
    //TC: O(N)
}
