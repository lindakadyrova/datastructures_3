package at.fhj.msd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 * A collection of search algorithms and array utilities.
 */
public class App {

    /**
     * Performs a linear search for the target value in the given array.
     *
     * @param arr the array to search
     * @param x   the value to search for
     * @return the index of the element if found, otherwise -1
     */
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * Performs a binary search on a sorted array.
     *
     * @param arr the sorted array to search
     * @param x   the value to search for
     * @return the index of the element if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x)
                return mid;
            if (arr[mid] < x)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    /**
     * Performs an interpolation search on a sorted array.
     * Most efficient for uniformly distributed values.
     *
     * @param arr the sorted array to search
     * @param x   the value to search for
     * @return the index of the element if found, otherwise -1
     */
    public static int interpolationSearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high && x >= arr[low] && x <= arr[high]) {
            int pos = low + ((x - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == x)
                return pos;
            if (arr[pos] < x)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }

    /**
     * Performs a quadratic binary search on a sorted array.
     * Combines jump and linear search.
     *
     * @param arr the sorted array to search
     * @param x   the value to search for
     * @return the index of the element if found, otherwise -1
     */
    public static int quadraticBinarySearch(int[] arr, int x) {
        int step = (int) Math.sqrt(arr.length);
        int prev = 0;
        while (prev < arr.length && arr[prev] < x)
            prev += step;
        for (int i = Math.max(0, prev - step); i < Math.min(prev, arr.length); i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }

    /**
     * Generates a randomized array of integers.
     * Values are in the range [1, maxValue]. Duplicates may occur.
     *
     * @param size     the number of elements to generate
     * @param maxValue the maximum value (inclusive) for elements
     * @return a shuffled array of integers
     */
    public static int[] generateRandomArray(int size, int maxValue) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= maxValue; i++) {
            list.add(i);
        }

        while (list.size() < size) {
            list.add(random.nextInt(maxValue) + 1);
        }

        Collections.shuffle(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    /**
     * Main method for generating arrays and manually testing search methods.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        int[] sizes = { 100, 1000, 10000, 100000 };
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size, 100);
            int[] sortedArray = randomArray.clone();
            Arrays.sort(sortedArray);

            // Manual test area
        }
    }
}
