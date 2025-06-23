package p05_dynamic_programming.p04_string_transformation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n, m;
    static char[] X, F;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();
        X = (" " + sc.nextLine().trim()).toCharArray(); // từ chỉ số 1
        F = (" " + sc.nextLine().trim()).toCharArray(); // từ chỉ số 1

        dp = new int[n + 1][m + 1];

        // Khởi tạo cơ bản
        for (int i = 0; i <= n; i++)
            dp[i][0] = i;
        for (int j = 0; j <= m; j++)
            dp[0][j] = j;

        // DP bảng
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (X[i] == F[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j - 1], // replace
                            Math.min(dp[i][j - 1], // insert
                                    dp[i - 1][j]) // delete
                    );
                }
            }
        }

        // In bảng phương án
        System.out.printf("%4s", "F");
        for (int j = 0; j <= m; j++) {
            System.out.printf("%4d", j);
        }
        System.out.println();

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.printf("%4d", 0);
            } else {
                System.out.printf("%4d", i);
            }
            for (int j = 0; j <= m; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        // In số phép biến đổi
        System.out.println(dp[n][m]);

        // Truy vết để in danh sách phép biến đổi
        List<String> ops = new ArrayList<>();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && X[i] == F[j]) {
                i--;
                j--;
            } else if (i > 0 && j > 0 && dp[i][j] == dp[i - 1][j - 1] + 1) {
                ops.add("Replace(" + i + "," + F[j] + ")");
                i--;
                j--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1] + 1) {
                ops.add("Insert(" + i + "," + F[j] + ")");
                j--;
            } else if (i > 0 && dp[i][j] == dp[i - 1][j] + 1) {
                ops.add("Delete(" + i + ")");
                i--;
            }
        }

        Collections.reverse(ops);
        for (String op : ops) {
            System.out.println(op);
        }
    }
}
