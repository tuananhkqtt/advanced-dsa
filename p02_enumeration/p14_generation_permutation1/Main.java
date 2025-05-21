package p02_enumeration.p14_generation_permutation1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = n - i;
        }
        print(a);
        while (prevPerm(a)) {
            print(a);
        }
    }

    static boolean prevPerm(int[] a) {
        int i = a.length - 2;
        while (i >= 0 && a[i] <= a[i + 1]) {
            i--;
        }
        if (i < 0)
            return false;
        int j = a.length - 1;
        while (a[j] >= a[i]) {
            j--;
        }
        swap(a, i, j);
        reverse(a, i + 1, a.length - 1);
        return true;
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void reverse(int[] a, int l, int r) {
        while (l < r) {
            swap(a, l++, r--);
        }
    }

    static void print(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]);
            if (i < a.length - 1)
                System.out.print(" ");
        }
        System.out.println();
    }
}
