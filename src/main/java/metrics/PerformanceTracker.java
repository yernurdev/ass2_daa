package metrics;

public class PerformanceTracker {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;
    private long startTime;
    private long endTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void stop() {
        endTime = System.nanoTime();
    }

    public long getElapsedMillis() {
        return (endTime - startTime) / 1_000_000;
    }

    // --- increment methods ---
    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void addAccesses(long n) { arrayAccesses += n; }

    // --- getters (нужны для BenchmarkRunner) ---
    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }

    public String toCsvLine(int n) {
        return n + "," + getElapsedMillis() + "," + comparisons + "," + swaps + "," + arrayAccesses;
    }
}
