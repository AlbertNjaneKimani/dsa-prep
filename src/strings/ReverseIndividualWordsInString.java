package strings;
import java.util.*;
public class ReverseIndividualWordsInString {
    /*
    Solution:
    - We take two string: final_string & temp_string, temp_string help in reversing individual words & final_string will be the final string that we'll return as answer
    - We iterate the complete string from 0th index till end
    - While iteration, whereever we find the non-space character, we keep on adding character in temp_string & whenever we find the space, we append temp_string in final_string.

    Time Complexity: O(n)
    Space Complexity: O(1)

    Solution - 2
    - Rather than String, we can use StringBuilder as well to improve the space complexity.

    Time Complexity: O(n)
    Space Complexity: O(1)

    Solution - 3:
    - Create a stack & keep on adding character until you find space
    - When you find space, just pop character from stack & keep on printing the element

    Time Complexity: O(n)
    Space Complexity: O(n)

    * */
    public String reverseIndividualWord(String str) {

        String finalStr = "";
        String tempStr = "";

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ' ') {
                finalStr = finalStr + tempStr + " ";
                tempStr = "";
            } else {
                tempStr = c + tempStr;
            }
        }

        finalStr = finalStr + tempStr;

        return finalStr;
    }

    public String reverseIndividualWordStringBuilder(String str) {

        StringBuilder finalStr = new StringBuilder();
        StringBuilder tempStr = new StringBuilder();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ' ') {
                finalStr = finalStr.append(tempStr).append(" ");
                tempStr.setLength(0);
            } else {
                tempStr.insert(0, c);
            }
        }

        finalStr = finalStr.append(tempStr);

        return finalStr.toString();
    }

    public void reverseIndividualWordStack(String str) {

        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if(c == ' ') {
                while(!st.isEmpty()) {
                    System.out.print(st.pop());
                }
                System.out.print(" ");
            } else {
                st.push(c);
            }
        }

        while(!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }
}

public class StringApp {

    public static void main(String[] args) {
        ReverseIndividualWordsInString obj = new ReverseIndividualWordsInString();

        String str = "coding simplified nice";

        System.out.println(obj.reverseIndividualWord(str));
        System.out.println(obj.reverseIndividualWordStringBuilder(str));

        obj.reverseIndividualWordStack(str);

    }
}
