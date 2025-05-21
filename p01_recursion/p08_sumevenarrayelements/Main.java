package p01_recursion.p08_sumevenarrayelements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int sumEven(int[] a, int i) {
        if (i == a.length)
            return 0;
        return (a[i] % 2 == 0 ? a[i] : 0) + sumEven(a, i + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(parts[i]);
        System.out.print(sumEven(a, 0));
    }
}
