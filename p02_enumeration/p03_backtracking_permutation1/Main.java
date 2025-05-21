package p02_enumeration.p03_backtracking_permutation1;

import java.util.Scanner;

public class Main {
    static int[] a;
    static boolean[] used;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();
        a = new int[n];
        used = new boolean[n + 1];
        backtrack(0);
    }

    static void backtrack(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(a[i]);
                if (i < n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int v = n; v >= 1; v--) {
                if (!used[v]) {
                    used[v] = true;
                    a[k] = v;
                    backtrack(k + 1);
                    used[v] = false;
                }
            }
        }
    }
}
