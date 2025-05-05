package recursion.p07_computefunction2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static double f(int i, int n) {
        if (i > n)
            return 0;
        return Math.sqrt(i + f(i + 1, n));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(br.readLine().trim());
            double res = f(1, n);
            sb.append(String.format("%.10f", res));
            if (k < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
