package strings;

import java.util.*;

public class MostFrequentWordAfterExcludingGivenWord {
    /*
    - Replace all punctuations with space
    - Split string to string array by one or more space
    - Create frequency map of each word
    - Remove exluding word from frequency map
    - Now create TreeMap with comparator based on decresing frequency & alphabetically
    - Put all values in TreeMap which'll arrange in decresing frequency & alphabetically
     (If frequency is same then alphabetically)
    - Get most frequency value
    - Put all word from map one by which has frequency equal to most frequency.
    - Return this final list
*/
    public static List<String> mostFrequentWords(String helpText, String[] excluded) {
        helpText = helpText.replaceAll("[^a-zA-Z0-9]", " ");
        String[] allWords = helpText.split(" +");
        Map<String, Integer> countingMap = new HashMap<>();
        // put all words in a map and thier frequencies
        for (String word : allWords) {
            word = word.toLowerCase();
            countingMap.put(word, countingMap.getOrDefault(word, 0) + 1);
        }
        for(String exclude: excluded){
            if(countingMap.containsKey(exclude)){
                countingMap.remove(exclude);
            }
        }
        // use a tree map and comparator to compare two values in a tree map .
        TreeMap<String, Integer> mostFrequentMap = new TreeMap<>((e1, e2) -> {
            int freq1 = countingMap.get(e1);
            int freq2 = countingMap.get(e2);
            // if frequencies are not matching arrange in decreasing manner
            if (freq1 != freq2) {
                return freq2 - freq1;
            }
            // if frequencies are not matching arrange alphabetically
            return e1.compareTo(e2);
        });
        //put all value of countingamp into tree map
        mostFrequentMap.putAll(countingMap);
        List<String> mostFrequentWord = new ArrayList<>();
        // get first entry value
        int topFreq = mostFrequentMap.firstEntry().getValue();
        while(!mostFrequentMap.isEmpty()){
            Map.Entry<String, Integer> word = mostFrequentMap.pollFirstEntry();
            if(word.getValue() == topFreq){
                mostFrequentWord.add(word.getKey());
            }
            else{
                break;
            }
        }
        return mostFrequentWord;
    }
    public static void main(String [] args){
        String text ="Best items in category are Samsung Lenovo. Samsung items are nice. Lenovo are cool";
        String [] exclude ={"are", "in"};
        MostFrequentWordAfterExcludingGivenWord mf = new MostFrequentWordAfterExcludingGivenWord();
        List<String> res = mf.mostFrequentWords(text,exclude);
        System.out.println(res);
    }
    //TC: O(nlogn)
    //SP:O(n)
}
