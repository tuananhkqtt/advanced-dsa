package p03_divideandconquer.p07_quicksortdescending;

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
        sort(a, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (int v : a)
            sb.append(v).append(' ');
        System.out.println(sb.toString().trim());
    }

    static void sort(int[] a, int low, int high) {
        if (low < high) {
            int i = low, j = high;
            int pivot = a[(low + high) / 2];
            while (i <= j) {
                while (a[i] > pivot)
                    i++;
                while (a[j] < pivot)
                    j--;
                if (i <= j) {
                    int tmp = a[i];
                    a[i] = a[j];
                    a[j] = tmp;
                    i++;
                    j--;
                }
            }
            if (low < j)
                sort(a, low, j);
            if (i < high)
                sort(a, i, high);
        }
    }
}
