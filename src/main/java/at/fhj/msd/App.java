package at.fhj.msd;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class App {

    // Linear Search
    public static int linearSearch(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // Binary Search (requires sorted array)
    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return mid;
            if (arr[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    // Interpolation Search (requires sorted array)
    public static int interpolationSearch(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        while (low <= high && x >= arr[low] && x <= arr[high]) {
            int pos = low + ((x - arr[low]) * (high - low)) / (arr[high] - arr[low]);
            if (arr[pos] == x) return pos;
            if (arr[pos] < x) low = pos + 1;
            else high = pos - 1;
        }
        return -1;
    }

    // Quadratic Binary Search (requires sorted array)
    public static int quadraticBinarySearch(int[] arr, int x) {
        int step = (int) Math.sqrt(arr.length);
        int prev = 0;
        while (prev < arr.length && arr[prev] < x) prev += step;
        for (int i = Math.max(0, prev - step); i < Math.min(prev, arr.length); i++) {
            if (arr[i] == x) return i;
        }
        return -1;
    }

    // Generate randomized array
    public static int[] generateRandomArray(int size, int maxValue) {
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        
        // Fill with values 1 to maxValue
        for (int i = 1; i <= maxValue; i++) {
            list.add(i);
        }
        
        // Add random values if size > maxValue
        while (list.size() < size) {
            list.add(random.nextInt(maxValue) + 1);
        }
        
        // Shuffle the array
        Collections.shuffle(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    // Example usage (you'll replace this with your JUnit tests)
    public static void main(String[] args) {
        // Generate test arrays of different sizes
        int[] sizes = {100, 1000, 10000, 100000};
        for (int size : sizes) {
            int[] randomArray = generateRandomArray(size, 100);
            int[] sortedArray = randomArray.clone();
            Arrays.sort(sortedArray);
            
            // Now you can test your search methods here
            // Or better - write JUnit tests
        }
    }
}