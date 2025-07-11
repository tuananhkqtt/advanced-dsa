package study_questions.p03_mergesort_rightfirst;

import java.util.Scanner;

public class Main {
    public static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;

            System.out.println("Divide: " + (m + 1) + " --> " + r + " and " + l + " --> " + m);
            printSubArrays(a, m + 1, r, l, m);

            mergeSort(a, m + 1, r);
            mergeSort(a, l, m);

            System.out.println("Merge: " + (m + 1) + " --> " + r + " and " + l + " --> " + m);
            merge(a, l, m, r);
            printRange(a, l, r);
            System.out.println();
        }
    }

    public static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = a[l + i];
        for (int i = 0; i < n2; i++) R[i] = a[m + 1 + i];

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) a[k++] = L[i++];
            else a[k++] = R[j++];
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    public static void printSubArrays(int[] a, int r1l, int r1r, int r2l, int r2r) {
        for (int i = r1l; i <= r1r; i++) System.out.print(" " + a[i]);
        System.out.print(" ::");
        for (int i = r2l; i <= r2r; i++) System.out.print(" " + a[i]);
        System.out.println();
    }

    public static void printRange(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (i > l) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.println("Input:");
        printArray(a);
        System.out.println();
        mergeSort(a, 0, n - 1);
    }
}

/*
Input 1:
6
10 9 8 7 6 5
Output 1:
Input:
10 9 8 7 6 5

Divide: 3 --> 5 and 0 --> 2
7 6 5 :: 10 9 8
Divide: 4 --> 5 and 3 --> 3
6 5 :: 7
Divide: 5 --> 5 and 4 --> 4
5 :: 6
Merge: 5 --> 5 and 4 --> 4
5 6 

Merge: 4 --> 5 and 3 --> 3
5 6 7 

Merge: 3 --> 5 and 0 --> 2
5 6 7 8 9 10 

*/

