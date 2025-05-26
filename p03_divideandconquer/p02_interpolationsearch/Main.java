package p03_divideandconquer.p02_interpolationsearch;

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
        System.out.println(sb.toString().trim());
        int n = Integer.parseInt(br.readLine().trim());
        while (n-- > 0) {
            int x = Integer.parseInt(br.readLine().trim());
            System.out.println(interpolationSearch(a, x));
        }
    }

    static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(a, l, m);
            sort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = a[l + i];
        for (int j = 0; j < n2; j++)
            R[j] = a[m + 1 + j];
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                a[k++] = L[i++];
            else
                a[k++] = R[j++];
        }
        while (i < n1)
            a[k++] = L[i++];
        while (j < n2)
            a[k++] = R[j++];
    }

    static int interpolationSearch(int[] a, int x) {
        int low = 0, high = a.length - 1;
        while (low <= high && x >= a[low] && x <= a[high]) {
            if (a[low] == a[high]) {
                if (a[low] == x)
                    return low;
                else
                    break;
            }
            int pos = low + (int) (((long) (x - a[low]) * (high - low)) / (a[high] - a[low]));
            if (pos < low || pos > high)
                break;
            if (a[pos] == x)
                return pos;
            if (a[pos] < x)
                low = pos + 1;
            else
                high = pos - 1;
        }
        return -1;
    }
}
