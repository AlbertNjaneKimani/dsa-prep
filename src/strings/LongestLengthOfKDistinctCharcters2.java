package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestLengthOfKDistinctCharcters2 {
    /*sudo code: Function longestLength(str, K):
    If str is null or empty or str's length is less than K:
        Return 0

    Initialize maxLength to 0
    Initialize start and end pointers to 0
    Initialize an empty HashMap called map to track characters and their counts

    While end < length(str):
        currentChar = str[end]

        Add currentChar to map or increment its count

        While the number of distinct characters in map is greater than K:
            startChar = str[start]
            Decrement the count of startChar in map
            If the count becomes 0, remove startChar from map
            Increment start pointer by 1

        Calculate currentLength as (end - start + 1)

        Update maxLength to max of (maxLength, currentLength)

        Increment end pointer by 1

    Return maxLength

Main:
    Initialize str as the input string
    Initialize K as the maximum number of distinct characters allowed
    Call longestLength(str, K) and store the result in res
    Print res*/
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