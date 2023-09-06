package strings;

public class LongestSubstringWithSameLetterAfterReplacement {
    //find the longest substring with same letter if "K" characters can be replaced
    // str ="bccbababd", k =2, output = 5
    // formular: maxLength - maxFrequency > k
    // if maxLength - maxFrequency > K:
    //1. remove the firstwindow character(character at start) from the window
    //2. decrease the frequency of that character
    //3. increase the start
    //maxFrequency = max(maxFrequency, map.get(currentChar))
    //maxLength = max(maxLength, end-start +1)
}
