package recursion;

public class Fibonacci {
    public static int fibonacci(int n) {
        // Base Case: F(0) = 0, F(1) = 1
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        // Recursive Case: F(n) = F(n-1) + F(n-2)
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        int num = 7;
        System.out.println("Fibonacci ke-" + num + " adalah " + fibonacci(num));
    }
}
