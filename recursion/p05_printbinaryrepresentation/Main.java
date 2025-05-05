package recursion.p05_printbinaryrepresentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static void toBinary(int n, StringBuilder sb) {
        if (n > 1)
            toBinary(n / 2, sb);
        sb.append(n % 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            StringBuilder sb = new StringBuilder();
            toBinary(n, sb);
            out.append(sb);
            if (i < t - 1)
                out.append('\n');
        }
        System.out.print(out);
    }
}
