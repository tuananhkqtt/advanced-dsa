package p03_divideandconquer.p05_mergesortprocesslefttoright;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] temp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(parts[i]);
        StringBuilder sbInit = new StringBuilder();
        for (int v : a)
            sbInit.append(v).append(" ");
        System.out.println(sbInit.toString());
        temp = new int[n];
        mergeSortProcess(a, 0, n - 1);
    }

    static void mergeSortProcess(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            System.out.println("Divide: " + l + " --> " + m + " and " + (m + 1) + " --> " + r);
            StringBuilder sb = new StringBuilder();
            for (int i = l; i <= m; i++)
                sb.append(a[i]).append(" ");
            sb.append(":: ");
            for (int i = m + 1; i <= r; i++)
                sb.append(a[i]).append(" ");
            System.out.println(sb.toString());
            mergeSortProcess(a, l, m);
            mergeSortProcess(a, m + 1, r);
            System.out.println("Merge: " + l + " --> " + m + " and " + (m + 1) + " --> " + r);
            merge(a, l, m, r);
            StringBuilder sb2 = new StringBuilder();
            for (int i = l; i <= r; i++)
                sb2.append(a[i]).append(" ");
            System.out.println(sb2.toString());
        }
    }

    static void merge(int[] a, int l, int m, int r) {
        int i = l, j = m + 1, k = l;
        while (i <= m && j <= r) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else
                temp[k++] = a[j++];
        }
        while (i <= m)
            temp[k++] = a[i++];
        while (j <= r)
            temp[k++] = a[j++];
        for (int t = l; t <= r; t++)
            a[t] = temp[t];
    }
}
