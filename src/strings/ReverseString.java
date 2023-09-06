package strings;

public class ReverseString {
    /*sudo code:
    * Function reverseString(str):
    Initialize start to 0
    Initialize end to length(str) - 1
    Convert str to a character array ch

    While start < end:
        // Swap characters at start and end positions
        temp = ch[start]
        ch[start] = ch[end]
        ch[end] = temp

        Increment start by 1
        Decrement end by 1

    Return String.copyValueOf(ch)

Main:
    Initialize str as the input string
    Call reverseString(str) and store the result in reversed
    Print reversed*/
    public String reverseString(String str) {
        //i am using two pointers
        int start = 0;
        int end = str.length()-1;
        char[] ch = str.toCharArray();
        while (start < end) {
            char c = ch[start];
            ch[start] = ch[end];
            ch[end] = c;
            start++;
            end--;
        }
        return String.copyValueOf(ch);
    }
    public static void main(String [] args){
        ReverseString rs = new ReverseString();
        String reversed = rs.reverseString("albert");
        System.out.println(reversed);
    }
}
//Tc: O(n)
//Sp: O(1)