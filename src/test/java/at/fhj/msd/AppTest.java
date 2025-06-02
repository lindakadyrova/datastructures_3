package at.fhj.msd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private static int[] smallUnsorted;
    private static int[] smallSorted;
    private static int[] withDuplicates;

    @BeforeAll
    static void setUp() {
        smallUnsorted = new int[] { 5, 1, 8, 3, 7 };
        smallSorted = smallUnsorted.clone();
        Arrays.sort(smallSorted);
        withDuplicates = new int[] { 2, 4, 4, 4, 9, 2, 7 };
        Arrays.sort(withDuplicates);
    }

    @Test
    void testLinearSearchFound() {
        assertEquals(2, App.linearSearch(smallUnsorted, 8));
        assertEquals(0, App.linearSearch(smallUnsorted, 5));
    }

    @Test
    void testLinearSearchNotFound() {
        assertEquals(-1, App.linearSearch(smallUnsorted, 99));
    }

    @Test
    void testBinarySearchFound() {
        assertEquals(2, App.binarySearch(smallSorted, 5));
        assertTrue(App.binarySearch(smallSorted, 1) >= 0);
        assertTrue(App.binarySearch(smallSorted, 8) >= 0);
    }

    @Test
    void testBinarySearchNotFound() {
        assertEquals(-1, App.binarySearch(smallSorted, 99));
    }

    @Test
    void testInterpolationSearchFound() {
        assertTrue(App.interpolationSearch(smallSorted, 3) >= 0);
        assertTrue(App.interpolationSearch(smallSorted, 7) >= 0);
    }

    @Test
    void testInterpolationSearchNotFound() {
        assertEquals(-1, App.interpolationSearch(smallSorted, 42));
    }

    @Test
    void testQuadraticBinarySearchNotFound() {
        assertEquals(-1, App.quadraticBinarySearch(smallSorted, 999));
    }

    @Test
    void testGenerateRandomArraySizeAndRange() {
        int[] randomArray = App.generateRandomArray(100, 50);
        assertEquals(100, randomArray.length);
        for (int num : randomArray) {
            assertTrue(num >= 1 && num <= 50);
        }
    }
}
