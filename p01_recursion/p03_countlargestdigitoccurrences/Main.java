package p01_recursion.p03_countlargestdigitoccurrences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int maxDigit(long n) {
        if (n < 10)
            return (int) n;
        int d = (int) (n % 10);
        int m = maxDigit(n / 10);
        return d > m ? d : m;
    }

    static int countMax(long n, int max) {
        if (n < 10)
            return n == max ? 1 : 0;
        int d = (int) (n % 10);
        return countMax(n / 10, max) + (d == max ? 1 : 0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine().trim();
            long n = Long.parseLong(s);
            int m = maxDigit(n);
            int c = countMax(n, m);
            sb.append(String.format("%10s: %d", s, c));
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
