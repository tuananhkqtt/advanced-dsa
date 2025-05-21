package p01_recursion.p02_determinelargestdigit;

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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String s = br.readLine().trim();
            long n = Long.parseLong(s);
            int md = maxDigit(n);
            sb.append(String.format("%10s: %d", s, md));
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
