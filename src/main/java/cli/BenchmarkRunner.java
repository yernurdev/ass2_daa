package cli;

import algorithms.HeapSort;
import metrics.PerformanceTracker;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BenchmarkRunner {

    public static void main(String[] args) throws IOException {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] distributions = {"random", "sorted", "reversed", "nearly"};
        for (String dist : distributions) {
            String file = "docs/performance-plots/heapsort_" + dist + ".csv";
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("n,time_ms,comparisons,swaps,array_accesses\n");
                for (int n : sizes) {
                    int[] arr = generateArray(n, dist);
                    PerformanceTracker t = new PerformanceTracker();
                    HeapSort.sort(arr, t);
                    fw.write(t.toCsvLine(n) + "\n");
                    System.out.printf("[%s] n=%d time=%dms comps=%d%n", dist, n, t.getElapsedMillis(), t.getComparisons());
                }
            }
        }
    }

    private static int[] generateArray(int n, String type) {
        Random rnd = new Random(42);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = rnd.nextInt(100000);
        if (type.equals("sorted")) Arrays.sort(arr);
        if (type.equals("reversed")) {
            Arrays.sort(arr);
            for (int i = 0; i < n / 2; i++) {
                int tmp = arr[i];
                arr[i] = arr[n - 1 - i];
                arr[n - 1 - i] = tmp;
            }
        }
        if (type.equals("nearly")) {
            Arrays.sort(arr);
            for (int i = 0; i < Math.max(1, n / 100); i++) {
                int x = rnd.nextInt(n);
                int y = rnd.nextInt(n);
                int tmp = arr[x];
                arr[x] = arr[y];
                arr[y] = tmp;
            }
        }
        return arr;
    }
}
