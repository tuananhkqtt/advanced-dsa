package study_questions.p01_mergesort;

import java.util.Scanner;

public class Main {
    public static void mergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            System.out.println("Divide: " + l + " --> " + m + " and " + (m + 1) + " --> " + r);
            printSubArray(a, l, m);
            System.out.print(" :: ");
            printSubArray(a, m + 1, r);
            System.out.println();
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            System.out.println("Merge: " + l + " --> " + m + " and " + (m + 1) + " --> " + r);
            merge(a, l, m, r);
            printArray(a);
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
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                a[k++] = R[j++];
            }
        }

        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void printSubArray(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (i > l) System.out.print(" ");
            System.out.print(a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        printArray(a);
        mergeSort(a, 0, n - 1);
    }
}

/*
Input 1:
10
759 405 509 343 947 326 831 790 232 372

Output 1:
759 405 509 343 947 326 831 790 232 372
Divide: 0 --> 4 and 5 --> 9
759 405 509 343 947 :: 326 831 790 232 372
Divide: 0 --> 2 and 3 --> 4
759 405 509 :: 343 947
Divide: 0 --> 1 and 2 --> 2
759 405 :: 509
Divide: 0 --> 0 and 1 --> 1
759 :: 405
Merge: 0 --> 0 and 1 --> 1
405 759 509 343 947 326 831 790 232 372
Merge: 0 --> 1 and 2 --> 2
405 509 759 343 947 326 831 790 232 372
Divide: 3 --> 3 and 4 --> 4
343 :: 947
Merge: 3 --> 3 and 4 --> 4
405 509 759 343 947 326 831 790 232 372
Merge: 0 --> 2 and 3 --> 4
343 405 509 759 947 326 831 790 232 372
Divide: 5 --> 7 and 8 --> 9
326 831 790 :: 232 372
Divide: 5 --> 6 and 7 --> 7
326 831 :: 790
Divide: 5 --> 5 and 6 --> 6
326 :: 831
Merge: 5 --> 5 and 6 --> 6
343 405 509 759 947 326 831 790 232 372
Merge: 5 --> 6 and 7 --> 7
343 405 509 759 947 326 790 831 232 372
Divide: 8 --> 8 and 9 --> 9
232 :: 372
Merge: 8 --> 8 and 9 --> 9
343 405 509 759 947 326 790 831 232 372
Merge: 5 --> 7 and 8 --> 9
343 405 509 759 947 232 326 372 790 831
Merge: 0 --> 4 and 5 --> 9
232 326 343 372 405 509 759 790 831 947

Input 2:
4
8 7 6 5

Output 2:
8 7 6 5
Divide: 0 --> 1 and 2 --> 3
8 7 :: 6 5
Divide: 0 --> 0 and 1 --> 1
8 :: 7
Merge: 0 --> 0 and 1 --> 1
7 8 6 5
Merge: 0 --> 1 and 2 --> 3
6 7 8 5
Merge: 0 --> 2 and 3 --> 3
5 6 7 8

Input 3:
3
1 2 3

Output 3:
1 2 3
Divide: 0 --> 1 and 2 --> 2
1 2 :: 3
Divide: 0 --> 0 and 1 --> 1
1 :: 2
Merge: 0 --> 0 and 1 --> 1
1 2 3
Merge: 0 --> 1 and 2 --> 2
1 2 3
*/
