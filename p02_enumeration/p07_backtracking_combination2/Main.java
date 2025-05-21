package p02_enumeration.p07_backtracking_combination2;

import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] comb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        sc.close();
        comb = new int[k];
        backtrack(0, n);
    }

    static void backtrack(int idx, int start) {
        if (idx == k) {
            for (int i = 0; i < k; i++) {
                System.out.print(comb[i]);
                if (i < k - 1)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int v = start; v >= 1; v--) {
                comb[idx] = v;
                backtrack(idx + 1, v - 1);
            }
        }
    }
}
