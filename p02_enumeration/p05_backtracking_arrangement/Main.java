package p02_enumeration.p05_backtracking_arrangement;

import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] comb;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.close();
        comb = new int[k];
        used = new boolean[n + 1];
        backtrack(0);
    }

    static void backtrack(int idx) {
        if (idx == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(comb[i]);
                if (i < k - 1)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int v = 1; v <= n; v++) {
                if (!used[v]) {
                    used[v] = true;
                    comb[idx] = v;
                    backtrack(idx + 1);
                    used[v] = false;
                }
            }
        }
    }
}
