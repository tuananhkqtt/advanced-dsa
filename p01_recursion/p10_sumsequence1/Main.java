package p01_recursion.p10_sumsequence1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static double fact(int n) {
        if (n <= 1)
            return 1;
        return n * fact(n - 1);
    }

    static double S(double x, int n) {
        if (n == 1)
            return x;
        return S(x, n - 1) + Math.pow(x, n) / fact(n);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            double x = Double.parseDouble(p[0]);
            int n = Integer.parseInt(p[1]);
            sb.append(String.format("%.8f", S(x, n)));
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
