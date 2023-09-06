package strings;

public class ReverseVowelsInAGivenString {
    // str ="equation"
    //output=""
    /*
    Solution: Using swapping
        - We take two variable start = 0 & end = n - 1
        - We iterate element from 'start' until we find a vowel,
          similarly we iterate from 'end' until we find a vowel
        - Now we swap the value
        - We do this until start is less than end

        Time Complexity: O(n), where n is number of characters in String
        Space Complexity: O(1)
    * */
    public static String reverseVowels(String str){
        int start =0 ;
        int end = str.length() -1;
        char[] charArr = str.toCharArray();
        while(start < end){
            if(!isVowel(charArr[start])){
                start ++;
                continue;
            }
            if(!isVowel(charArr[end])){
                end --;
                continue;
            }
            char c =charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = c;
            start++;
            end--;
        }
        return String.valueOf(charArr);
    }
    public static boolean isVowel(char c){
        if(c=='a'|| c=='A' || c=='e' || c=='E' || c=='i'
                || c=='I' || c=='o' || c=='O' || c=='u' || c=='U'){
            return true;
        }
        return false;
    }
    public static void main(String [] args){
        ReverseVowelsInAGivenString rv = new ReverseVowelsInAGivenString();
        String result = rv.reverseVowels("equation");
        System.out.println(result);
    }
    // TC: O(n/2)=>O(n)
    //SP: O(1)
}
