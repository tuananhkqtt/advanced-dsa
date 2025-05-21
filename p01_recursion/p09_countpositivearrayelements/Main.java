package p01_recursion.p09_countpositivearrayelements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int countPos(double[] a, int i) {
        if (i == a.length)
            return 0;
        return (a[i] > 0 ? 1 : 0) + countPos(a, i + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = Double.parseDouble(parts[i]);
        System.out.print(countPos(a, 0));
    }
}
