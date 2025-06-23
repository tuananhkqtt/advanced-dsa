package p05_dynamic_programming.p02_subsequence_sum_divisible_by_k;

import java.util.Scanner;

public class Main {
    static int n, k;
    static int[] a;
    static int[][] dp;
    static int[][] trace;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        a = new int[n + 1];
        dp = new int[n + 1][k];
        trace = new int[n + 1][k];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }

        // Initialize
        for (int j = 0; j < k; j++) {
            dp[0][j] = 0;
            trace[0][j] = 0;
        }

        // DP
        for (int i = 1; i <= n; i++) {
            int mod = a[i] % k;
            for (int j = 0; j < k; j++) {
                // Không chọn a[i]
                dp[i][j] = dp[i - 1][j];
                trace[i][j] = trace[i - 1][j];

                // Chọn a[i]
                int prev = (j - mod + k) % k;
                if (dp[i - 1][prev] + 1 > dp[i][j]) {
                    dp[i][j] = dp[i - 1][prev] + 1;
                    trace[i][j] = i;
                }
            }
        }

        // In bảng phương án
        System.out.print("n/t");
        for (int j = 0; j < k; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d", i);
            for (int j = 0; j < k; j++) {
                if (trace[i][j] == i && dp[i][j] != 0) {
                    System.out.printf("%4s", "+" + String.format("%02d", dp[i][j]));
                } else {
                    System.out.printf("%4s", String.format("%02d", dp[i][j]));
                }
            }
            System.out.println();
        }

        // Truy vết để tìm dãy con
        if (dp[n][0] == 0) {
            System.out.println("Day da cho thoa man yeu cau.");
            System.out.println("Tong = 0");
            return;
        }

        System.out.println("Chieu dai day con: " + dp[n][0]);

        int i = n, j = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();

        while (i > 0) {
            if (trace[i][j] == i) {
                sb.insert(0, "a[" + i + "]=" + a[i] + ";");
                sum += a[i];
                j = (j - a[i] % k + k) % k;
                i--;
                while (i > 0 && dp[i][j] != dp[i + 1][(j + a[i + 1] % k) % k] - 1) {
                    i--;
                }
            } else {
                i--;
            }
        }

        System.out.println(sb.toString());
        System.out.println("Tong =" + sum);
    }
}
