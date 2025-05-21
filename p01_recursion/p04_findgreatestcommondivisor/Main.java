package p01_recursion.p04_findgreatestcommondivisor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            String[] p = br.readLine().trim().split("\\s+");
            int a = Integer.parseInt(p[0]);
            int b = Integer.parseInt(p[1]);
            sb.append(gcd(a, b));
            if (i < t - 1)
                sb.append('\n');
        }
        System.out.print(sb);
    }
}
