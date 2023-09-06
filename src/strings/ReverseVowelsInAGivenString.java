package strings;

public class ReverseVowelsInAGivenString {
    // str ="equation"
    //output=""
    // use two pointers start and end. loop through the string using two pointers checking
    // if start and end are vowels. if they are vowels, swap them. after swapping, increase
    // the start and decrease the end while(start < end)
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
