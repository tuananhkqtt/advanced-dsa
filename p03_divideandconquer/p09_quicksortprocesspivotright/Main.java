package p03_divideandconquer.p09_quicksortprocesspivotright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(parts[i]);
        printArray(a, 0, n - 1);
        quickSortProcess(a, 0, n - 1);
        printArray(a, 0, n - 1);
    }

    static void printArray(int[] a, int l, int r) {
        for (int i = l; i <= r; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    static void quickSortProcess(int[] a, int low, int high) {
        if (low < high) {
            System.out.println();
            System.out.println("Partitioning: left=" + low + ", right=" + high);
            printArray(a, low, high);
            int pivot = a[high];
            int i = low - 1, j = high;
            while (true) {
                do {
                    i++;
                } while (i <= high && a[i] >= pivot);
                do {
                    j--;
                } while (j >= low && a[j] < pivot);
                if (i < j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    printArray(a, low, high);
                } else {
                    break;
                }
            }
            int tmp = a[i];
            a[i] = a[high];
            a[high] = tmp;
            printArray(a, low, high);
            quickSortProcess(a, low, i - 1);
            quickSortProcess(a, i + 1, high);
        }
    }
}
