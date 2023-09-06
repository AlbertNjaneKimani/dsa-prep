package strings;
import java.util.*;
public class CompareTwoStrings {
    //compare two strings with backspace character
    //str1 ="bcd##e" str2 ="bc#e"
    /*
    Solution:
        - We start from end for both the string & find out the valid characters
        - We do this for all characters. At any moment if we get not matching characters, we return false, else we return true in last.

        Time Complexity: O(n+m)
        Space Complexity: O(1)

    * */
    public static boolean ifStringEqualContainingBackspace(String str1, String str2) {
        int end1 = str1.length() - 1;
        int end2 = str2.length() - 1;

        while (end1 >= 0 && end2 >= 0) {
            int str1Index = getChar(str1, end1);
            int str2Index = getChar(str2, end2);

            if (str1Index < 0 && str2Index < 0) {
                return true;
            }

            if (str1Index < 0 || str2Index < 0) {
                return false;
            }

            if (str1.charAt(str1Index) != str2.charAt(str2Index)) {
                return false;
            }

            end1 = str1Index - 1;
            end2 = str2Index - 1;
        }

        if(end1 == -1 && end2 == -1)
            return true;
        else
            return false;
    }

    private static int getChar(String str, int end) {
        int specialChar = 0;

        while (end >= 0) {
            if (str.charAt(end) != '#') {
                if (specialChar == 0) {
                    return end;
                } else {
                    specialChar--;
                }
            } else {
                specialChar++;
            }

            end--;
        }

        return end;
    }

    public static void main(String[] args) {

        System.out.println(CompareTwoStrings.ifStringEqualContainingBackspace("bcd##e", "bd#e"));
    }
}
