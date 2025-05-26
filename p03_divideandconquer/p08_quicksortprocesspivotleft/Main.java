package p03_divideandconquer.p08_quicksortprocesspivotleft;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    static boolean firstPartition = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out), false);

        int n = Integer.parseInt(br.readLine().trim());
        int[] a = new int[n];
        String[] parts = br.readLine().trim().split("\\s+");
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(parts[i]);

        StringBuilder sb = new StringBuilder();
        for (int v : a)
            sb.append(v).append(' ');
        out.println(sb.toString());
        out.println();

        quickSortProcess(a, 0, n - 1, out, sb);

        out.println();
        sb.setLength(0);
        for (int v : a)
            sb.append(v).append(' ');
        out.println(sb.toString());

        out.flush();
    }

    static void quickSortProcess(int[] a, int left, int right,
            PrintWriter out, StringBuilder sb) {
        if (left < right) {
            if (!firstPartition)
                out.println();
            firstPartition = false;

            out.println("Partitioning: left=" + left + ", right=" + right);
            printSegment(a, left, right, out, sb);

            int j = partition(a, left, right, out, sb);
            quickSortProcess(a, left, j - 1, out, sb);
            quickSortProcess(a, j + 1, right, out, sb);
        }
    }

    static int partition(int[] a, int left, int right,
            PrintWriter out, StringBuilder sb) {
        int pivot = a[left];
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && a[i] < pivot)
                i++;
            while (j >= left + 1 && a[j] > pivot)
                j--;
            if (i < j) {
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                printSegment(a, left, right, out, sb);
                i++;
                j--;
            } else {
                break;
            }
        }
        // Hoán với pivot
        int tmp = a[left];
        a[left] = a[j];
        a[j] = tmp;
        printSegment(a, left, right, out, sb);
        return j;
    }

    static void printSegment(int[] a, int left, int right,
            PrintWriter out, StringBuilder sb) {
        sb.setLength(0);
        for (int k = left; k <= right; k++) {
            sb.append(a[k]).append(' ');
        }
        out.println(sb.toString());
    }
}
