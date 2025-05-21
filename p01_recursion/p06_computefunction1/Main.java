package p01_recursion.p06_computefunction1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double S(int n) {
        if (n == 1)
            return Math.sqrt(1);
        return Math.sqrt(n + S(n - 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            double res = S(n);
            sb.append(String.format("%.10f", res));
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
