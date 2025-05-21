package p02_enumeration.p02_backtracking_print_binary_sequence2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        char[] a = new char[n];
        backtrack(a, 0, n);
    }

    static void backtrack(char[] a, int k, int n) {
        if (k == n) {
            System.out.println(new String(a));
        } else {
            a[k] = '1';
            backtrack(a, k + 1, n);
            a[k] = '0';
            backtrack(a, k + 1, n);
        }
    }
}
