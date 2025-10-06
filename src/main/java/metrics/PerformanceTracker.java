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

    public void incComparisons() { comparisons++; }
    public void incSwaps() { swaps++; }
    public void addAccesses(long n) { arrayAccesses += n; }

    public String toCsvLine(int n) {
        return n + "," + getElapsedMillis() + "," + comparisons + "," + swaps + "," + arrayAccesses;
    }
}
