package strings;

import java.util.*;

public class LongestLengthOfKDistinctCharcters {
    public static int findLength(String str, int K) {
        if (str.length() == 0 || str == null || str.length() < K) {
            throw new IllegalArgumentException();
        }
        int windowStart = 0;
        int maxLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar,map.getOrDefault(rightChar,0)+1);
            while(map.size()>K){
                char leftChar = str.charAt(windowStart);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart +1);

        }
        return maxLength;
    }
 public static void main(String [] args){
     LongestLengthOfKDistinctCharcters lk = new LongestLengthOfKDistinctCharcters();
     int res1 = lk.findLength("araaci",2);
     System.out.println(res1);
     int res2 = lk.findLength("araaci",1);
     System.out.println(res2);
     int res3 = lk.findLength("cbbebi",3);
     System.out.println(res3);
 }
}
