package algo.Dynamic;


public class FIbonacci {

    public int nth(int n) {
        int[] cache = new int[n + 1];
            nth(n, cache);
        return cache[n];
    }

    private int nth(int k, int[] cache) {
        if (k <= 1) {
            return k;
        } else if (cache[k] > 0) {
            return cache[k];
        }

        cache[k] = nth(k - 2, cache) + nth(k - 1, cache);
        System.out.println("K = " + k);
        return cache[k];
    }

    public static void main(String... args) {
        FIbonacci fibonacci = new FIbonacci();
        System.out.println("Fibonacci of 8th: " + fibonacci.nth(8));
    }
}
