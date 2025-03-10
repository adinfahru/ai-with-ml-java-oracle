package recursion;

public class Factorial {
    public static int factorial(int n) {
        // Base Case: Jika n == 0 atau n == 1, return 1
        if (n == 0 || n == 1) {
            return 1;
        }
        // Recursive Case: n! = n * (n-1)!
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = 5;
        System.out.println("Faktorial dari " + num + " adalah " + factorial(num));
    }
}
