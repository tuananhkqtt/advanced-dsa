package p02_enumeration.p04_backtracking_permutation2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[] arr;
    static int[] perm;
    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(arr);
        perm = new int[n];
        used = new boolean[n];
        backtrack(0);
    }

    static void backtrack(int k) {
        if (k == n) {
            for (int i = 0; i < n; i++) {
                System.out.print(perm[i]);
                if (i < n - 1)
                    System.out.print(" ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!used[i]) {
                    used[i] = true;
                    perm[k] = arr[i];
                    backtrack(k + 1);
                    used[i] = false;
                }
            }
        }
    }
}
