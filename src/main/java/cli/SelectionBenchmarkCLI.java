package cli;

import selectionsort.SelectionSort;
import metrics.PerformanceTracker;

import java.io.PrintWriter;
import java.util.Random;

public class SelectionBenchmarkCLI {
    public static void main(String[] args) throws Exception {
        int[] sizes = {100, 1000, 5000, 10000}; // можно менять под задание
        Random rnd = new Random(42);
        PerformanceTracker tracker = new PerformanceTracker();

        try (PrintWriter pw = new PrintWriter("selectionsort_bench.csv")) {
            pw.println("n,time_ns,comparisons,swaps,array_accesses");

            for (int n : sizes) {
                long sumTime = 0;
                long sumComp = 0, sumSwaps = 0, sumAccesses = 0;

                for (int t = 0; t < 5; t++) { // усредняем по 5 прогонам
                    int[] a = rnd.ints(n, -10_000, 10_001).toArray();

                    tracker.reset();
                    long t0 = System.nanoTime();
                    SelectionSort.sort(a, tracker);
                    long elapsed = System.nanoTime() - t0;

                    sumTime += elapsed;
                    sumComp += tracker.getComparisons();
                    sumSwaps += tracker.getSwaps();
                    sumAccesses += tracker.getArrayAccesses();
                }

                long avgTime = sumTime / 5;
                long avgComp = sumComp / 5;
                long avgSwaps = sumSwaps / 5;
                long avgAccesses = sumAccesses / 5;

                pw.printf("%d,%d,%d,%d,%d%n", n, avgTime, avgComp, avgSwaps, avgAccesses);
                System.out.printf("n=%d -> %.2f ms, comps=%d, swaps=%d, accesses=%d%n",
                        n, avgTime / 1e6, avgComp, avgSwaps, avgAccesses);
            }
        }
    }
}
