package algorithms;

import metrics.PerformanceTracker;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class HeapSortTest {

    @Test
    void testEmpty() {
        int[] arr = {};
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingle() {
        int[] arr = {7};
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{7}, arr);
    }

    @Test
    void testRandom() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2};
        int[] expected = arr.clone();
        Arrays.sort(expected);
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(expected, arr);
    }

    @Test
    void testDuplicates() {
        int[] arr = {5, 5, 5, 5};
        HeapSort.sort(arr, new PerformanceTracker());
        assertArrayEquals(new int[]{5, 5, 5, 5}, arr);
    }
}
