package p05_dynamic_programming.p03_knapsack_problem;

import java.util.Scanner;

public class Main {
    static int n, M;
    static int[] A, C;
    static int[][] dp;
    static boolean[][] taken;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        M = sc.nextInt();
        A = new int[n + 1];
        C = new int[n + 1];
        dp = new int[n + 1][M + 1];
        taken = new boolean[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            C[i] = sc.nextInt();
        }

        // DP
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                dp[i][j] = dp[i - 1][j]; // không chọn
                taken[i][j] = false;
                if (j >= A[i]) {
                    int value = dp[i - 1][j - A[i]] + C[i];
                    if (value > dp[i][j]) {
                        dp[i][j] = value;
                        taken[i][j] = true;
                    }
                }
            }
        }

        // In bảng phương án
        System.out.printf("%4s%4s%4s%4s", "C", "A", "i/v", "");
        for (int j = 0; j <= M; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        // Dòng đầu tiên (i = 0)
        System.out.printf("%12s", "");
        for (int j = 0; j <= M; j++) {
            System.out.printf("%4d", dp[0][j]);
        }
        System.out.println();

        // Các dòng còn lại
        for (int i = 1; i <= n; i++) {
            System.out.printf("%4d%4d%4d", C[i], A[i], i);
            for (int j = 0; j <= M; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        // Tổng giá trị
        System.out.println(dp[n][M]);

        // Truy vết để in danh sách đồ vật
        int j = M;
        StringBuilder res = new StringBuilder();
        for (int i = n; i >= 1; i--) {
            if (taken[i][j]) {
                res.insert(0, i + "(" + A[i] + "," + C[i] + ") ");
                j -= A[i];
            }
        }
        System.out.println(res.toString().trim());
    }
}
