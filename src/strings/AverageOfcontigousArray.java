package strings;

import java.util.Arrays;

class AverageOfContigousArray {
    //Given an array, find the average of all contiguous subarrays of size ‘K’ in it.

    static double[] findAverage(int k, int[] arr) {
        double[] results = new double[arr.length - k + 1];
        for (int i = 0; i <= arr.length - k; i++) {
            double sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
                results[i] = sum / k;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        AverageOfContigousArray av = new AverageOfContigousArray();
        double[] res = av.findAverage(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        System.out.println(Arrays.toString(res));
    }
}
//T O(N*K)