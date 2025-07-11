package study_questions.p02_knapsack_dp;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[n + 1];
        int[] C = new int[n + 1];
        for (int i = 1; i <= n; i++) A[i] = sc.nextInt();
        for (int i = 1; i <= n; i++) C[i] = sc.nextInt();

        int[][] dp = new int[n + 1][M + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                if (A[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - A[i]] + C[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.printf("%4s", "");
        for (int j = 0; j <= M; j++) System.out.printf("%4d", j);
        System.out.println();

        for (int i = 0; i <= n; i++) {
            if (i == 0) System.out.printf("%4s", "0");
            else System.out.printf("%4d", i);
            for (int j = 0; j <= M; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        System.out.println(dp[n][M]);

        int w = M;
        StringBuilder items = new StringBuilder();
        for (int i = n; i > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                items.insert(0, "Item " + i + " (Weight=" + A[i] + ", Value=" + C[i] + ")\n");
                w -= A[i];
            }
        }
        System.out.print(items.toString());
    }
}

/*
Input 1:
4 5
2 1 3 2
12 10 20 15
Output 1:
       0   1   2   3   4   5
   0   0   0   0   0   0   0
   1   0   0  12  12  12  12
   2   0  10  12  22  22  22
   3   0  10  12  22  30  32
   4   0  10  15  25  30  35
35
Item 4 (Weight=2, Value=15)
Item 3 (Weight=3, Value=20)

Input 2:
3 4
1 3 4
15 20 30
Output 2:
       0   1   2   3   4
   0   0   0   0   0   0
   1   0  15  15  15  15
   2   0  15  15  20  35
   3   0  15  15  20  35
35
Item 2 (Weight=3, Value=20)
Item 1 (Weight=1, Value=15)

Input 3:
2 3
2 2
30 40
Output 3:
       0   1   2   3
   0   0   0   0   0
   1   0   0  30  30
   2   0   0  40  40
40
Item 2 (Weight=2, Value=40)
*/
