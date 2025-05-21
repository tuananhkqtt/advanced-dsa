package p01_recursion.p01_factorialcomputationprocess;
import java.util.Scanner;

public class Main {
    static int factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 0; i <= n; i++) {
            System.out.println(i + "! = " + factorial(i));
        }
    }
}
