package p03_divideandconquer.p01_binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] a = new int[d];
        for (int i = 0; i < d; i++)
            a[i] = Integer.parseInt(parts[i]);
        sort(a, 0, d - 1);
        StringBuilder sb = new StringBuilder();
        for (int v : a)
            sb.append(v).append(' ');
        System.out.println(sb.toString());
        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            System.out.println(binarySearch(a, x));
        }
    }

    static void sort(int[] a, int low, int high) {
        if (low < high) {
            int i = low, j = high, pivot = a[(low + high) / 2];
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

    static int binarySearch(int[] a, int x) {
        int l = 0, r = a.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (a[m] == x)
                return m;
            if (a[m] < x)
                r = m - 1;
            else
                l = m + 1;
        }
        return -1;
    }
}
