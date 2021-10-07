package algo.recursion;

public class Fibonacci {


    public int nth(int n) {
        if(n <= 1) {
            return n;
        }
        return nth(n -1) + nth(n -2);
    }

    public static void main(String... args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println("Fibonacci of 8th: " + fibonacci.nth(8));
    }
}
