package at.fhj.msd;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class AppTest {

    @Test
    public void testLinearSearch_found() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, App.linearSearch(arr, 5));
    }

    @Test
    public void testLinearSearch_notFound() {
        int[] arr = {2, 4, 6, 8};
        assertEquals(-1, App.linearSearch(arr, 5));
    }

    @Test
    public void testBinarySearch_found() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(4, App.binarySearch(arr, 9));
    }

    @Test
    public void testBinarySearch_notFound() {
        int[] arr = {1, 2, 3, 4, 5};
        assertEquals(-1, App.binarySearch(arr, 6));
    }

    @Test
    public void testInterpolationSearch_found() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(2, App.interpolationSearch(arr, 30));
    }

    @Test
    public void testInterpolationSearch_notFound() {
        int[] arr = {10, 20, 30, 40, 50};
        assertEquals(-1, App.interpolationSearch(arr, 35));
    }

    @Test
    public void testQuadraticBinarySearch_found() {
        int[] arr = {1, 3, 5, 7, 9, 11, 13};
        assertEquals(3, App.quadraticBinarySearch(arr, 7));
    }

    @Test
    public void testQuadraticBinarySearch_notFound() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        assertEquals(-1, App.quadraticBinarySearch(arr, 9));
    }

    @Test
    public void testGenerateRandomArray_sizeCorrect() {
        int[] arr = App.generateRandomArray(50, 10);
        assertEquals(50, arr.length);
    }

    @Test
    public void testGenerateRandomArray_valuesInRange() {
        int[] arr = App.generateRandomArray(100, 20);
        for (int val : arr) {
            assertTrue(val >= 1 && val <= 20);
        }
    }

    @Test
    public void testGenerateRandomArray_duplicatesPossible() {
        int[] arr = App.generateRandomArray(200, 10);
        long uniqueCount = Arrays.stream(arr).distinct().count();
        assertTrue(uniqueCount <= 10); // Duplicates should exist when size > maxValue
    }
}
