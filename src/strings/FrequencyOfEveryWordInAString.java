package strings;
import java.util.*;
public class FrequencyOfEveryWordInAString {
    /*
    - Replace all punctuations with space
    - Split string to string array by one or more space
    - Create frequency map of each word
    - To print Alphabetically, use TreeMap which'll sort based on word
    - To Print Frequency wise, Use treeMap & use comparator based on frequency & compare

        Time Complexity: O(n)
        Space Complexity: O(n)
    * */
    public static Map<String, Integer> mostFrequent(String str) {

        str = str.replaceAll("[^a-zA-Z0-9]", " ");
        String[] allWords = str.split(" +");

        Map<String, Integer> countingMap = new HashMap<>();

        for (String word : allWords) {
            word = word.toLowerCase();
            countingMap.put(word, countingMap.getOrDefault(word, 0) + 1);
        }

        TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
            int freq1 = countingMap.get(e1);
            int freq2 = countingMap.get(e2);

            if (freq1 != freq2) {
                return freq2 - freq1;
            }

            return e1.compareTo(e2);
        });

        mostFrequentMap.putAll(countingMap);

        return mostFrequentMap;
    }

    public static void main(String[] args) {
        String str = "Best items in category are Samsung lenovo. Samsung items are nice. Lenovo are cool";

        System.out.println(FrequencyOfEveryWordInAString.mostFrequent(str));

    }
}
