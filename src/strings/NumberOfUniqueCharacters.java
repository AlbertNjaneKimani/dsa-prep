package strings;
import java.util.*;
public class NumberOfUniqueCharacters {
    /*
    Solution:
    - We take a Set variable, where we'll characters of string
    - Now we iterate the string & keep on putting all the charcaters one by one
    - Set always store the unique characters
    - At last Set size will the number of unique characters

    Time Complexity: O(n)
    Space Complexity: O(n)

     */
    public static int findUniqueCharactersString(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        return set.size();
    }

    public static void main(String[] args) {

        String str = "bccbababd";
        System.out.println(NumberOfUniqueCharacters.findUniqueCharactersString(str));
    }
}
