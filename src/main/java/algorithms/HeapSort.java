package algorithms;

import metrics.PerformanceTracker;

public class HeapSort {

    public static void sort(int[] arr, PerformanceTracker tracker) {
        if (arr == null || arr.length <= 1) return;
        tracker.start();

        buildMaxHeap(arr, tracker);
        int end = arr.length - 1;
        while (end > 0) {
            swap(arr, 0, end, tracker);
            end--;
            siftDown(arr, 0, end, tracker);
        }

        tracker.stop();
    }

    private static void buildMaxHeap(int[] arr, PerformanceTracker t) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            siftDown(arr, i, arr.length - 1, t);
        }
    }

    private static void siftDown(int[] arr, int start, int end, PerformanceTracker t) {
        int root = start;
        while (root * 2 + 1 <= end) {
            int child = root * 2 + 1;
            int swap = root;

            t.addAccesses(2);
            t.incComparisons();
            if (arr[swap] < arr[child]) swap = child;

            if (child + 1 <= end) {
                t.addAccesses(2);
                t.incComparisons();
                if (arr[swap] < arr[child + 1]) swap = child + 1;
            }

            if (swap == root) return;
            swap(arr, root, swap, t);
            root = swap;
        }
    }

    private static void swap(int[] arr, int i, int j, PerformanceTracker t) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        t.addAccesses(3);
        t.incSwaps();
    }
}
