package study_questions.p07_quicksort_trace_rightpivot;

import java.util.Scanner;

public class Main {
    public static void quickSort(int[] a, int l, int r) {
        if (l < r) {
            System.out.println("Partitioning: left=" + l + ", right=" + r);
            printRange(a, l, r);
            int p = partition(a, l, r);
            printRange(a, l, r);
            quickSort(a, l, p - 1);
            quickSort(a, p + 1, r);
        }
    }

    public static int partition(int[] a, int l, int r) {
        int pivot = a[r];
        int i = l, j = r-1;

        while (i <= j) {
            while (i < r && a[i] <= pivot) i++;
            while (j >= l && a[j] > pivot) j--;
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                printRange(a, l, r);
            }
        }

        if (a[i] > pivot) {
            int tmp = a[r];
            a[r] = a[i];
            a[i] = tmp;
            printRange(a, l, r);
        }

        return i;
    }

    public static void printRange(int[] a, int l, int r) {
        for (int i = l; i <= r; i++) {
            if (i > l) System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println();
    }

    public static void printFull(int[] a) {
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

        printFull(a);
        quickSort(a, 0, n - 1);
        printFull(a);
    }
}

/*
Input:
10
140 103 180 110 100 147 140 143 199 143

Output:
140 103 180 110 100 147 140 143 199 143
Partitioning: left=0, right=9
140 103 180 110 100 147 140 143 199 143
140 103 140 110 100 147 180 143 199 143
100 103 140 110 140 147 180 143 199 143
Partitioning: left=0, right=3
100 103 140 110
100 103 140 110
Partitioning: left=1, right=3
103 140 110
103 140 110
Partitioning: left=2, right=3
140 110
110 140
Partitioning: left=5, right=9
147 180 143 199 143
147 143 143 199 180
143 143 147 199 180
Partitioning: left=5, right=6
143 143
143 143
Partitioning: left=8, right=9
199 180
180 199
100 103 110 140 140 143 143 147 180 199
*/
