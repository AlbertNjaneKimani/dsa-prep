package strings;

import java.util.Arrays;
public class AverageOfArraySlidingWindow {
    /*sudo code: Function findAverages(k, arr):
    Create an empty array called result with a length of (length of arr - k + 1)
    Initialize windowSum to 0
    Initialize windowStart to 0

    For windowEnd from 0 to (length of arr - 1):
        Add arr[windowEnd] to windowSum

        If windowEnd >= (k - 1):
            Set result[windowStart] to (windowSum / k)
            Subtract arr[windowStart] from windowSum
            Increment windowStart by 1

    Return result

Main:
    Initialize k to the desired window size
    Initialize arr to the input integer array
    Call findAverages(k, arr) and store the result in res
    Print res*/
    public static double[] findAverages(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            windowSum += arr[windowEnd];
            if (windowEnd >= k - 1) {
                result[windowStart] = windowSum / k;
                windowSum -= arr[windowStart];
                windowStart++;
            }
        }
        return  result;

    }
    public static void main(String [] args){
        AverageOfArraySlidingWindow av = new AverageOfArraySlidingWindow();
        double [] res = av.findAverages(5, new int[]{1,3,2,6,-1,4,1,8,2});
        System.out.println(Arrays.toString(res));
    }
}
// O(N)