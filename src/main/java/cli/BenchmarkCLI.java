package cli;

import insertionsort.InsertionSort;
import java.io.PrintWriter;
import java.util.Random;

public class BenchmarkCLI {
    public static void main(String[] args) throws Exception {
        int[] sizes = {10_000, 30_000, 60_000, 100_000};
        Random rnd = new Random(42);
        try (PrintWriter pw = new PrintWriter("bench.csv")) {
            pw.println("n,time_ns");
            for (int n : sizes) {
                long sum = 0;
                for (int i = 0; i < 5; i++) {
                    int[] a = rnd.ints(n, -10_000, 10_001).toArray();
                    long t0 = System.nanoTime();
                    InsertionSort.sort(a);
                    sum += System.nanoTime() - t0;
                }
                long avg = sum / 5;
                pw.printf("%d,%d%n", n, avg);
                System.out.printf("%d -> %.2f ms%n", n, avg / 1e6);
            }
        }
    }
}
