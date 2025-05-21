package p01_recursion.p12_checkallnegativevalues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean allNeg(double[] a, int i) {
        if (i == a.length)
            return true;
        return a[i] < 0 && allNeg(a, i + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] parts = br.readLine().trim().split("\\s+");
            double[] a = new double[n];
            for (int i = 0; i < n; i++)
                a[i] = Double.parseDouble(parts[i]);
            boolean ok = allNeg(a, 0);
            sb.append(ok ? "Yes" : "No");
            if (k < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
