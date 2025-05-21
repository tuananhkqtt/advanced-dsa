package p01_recursion.p11_sequence1elementvalue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] seq(int n) {
        if (n == 0)
            return new long[] { 1, 0 };
        long[] p = seq(n - 1);
        long x = p[0] + p[1];
        long y = 3 * p[0] + p[1];
        return new long[] { x, y };
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] r = seq(n);
            sb.append(r[0]).append(' ').append(r[1]);
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
