package test.p09_edit_distance_dp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = " " + s1;
        s2 = " " + s2;

        int[][] dp = new int[n + 1][m + 1];
        int[][] op = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    op[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    op[i][j] = 1;
                    if (dp[i - 1][j] + 1 < dp[i][j]) {
                        dp[i][j] = dp[i - 1][j] + 1;
                        op[i][j] = 2;
                    }
                    if (dp[i][j - 1] + 1 < dp[i][j]) {
                        dp[i][j] = dp[i][j - 1] + 1;
                        op[i][j] = 3;
                    }
                }
            }

        System.out.printf("%4s", "");
        for (int j = 0; j <= m; j++) System.out.printf("%4d", j);
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d", i);
            for (int j = 0; j <= m; j++) {
                System.out.printf("%4d", dp[i][j]);
            }
            System.out.println();
        }

        System.out.println(dp[n][m]);

        LinkedList<String> ops = new LinkedList<>();
        int i = n, j = m;
        while (i > 0 || j > 0) {
            if (i > 0 && j > 0 && op[i][j] == 0) {
                i--;
                j--;
            } else if (i > 0 && j > 0 && op[i][j] == 1) {
                ops.addFirst("Replace(" + i + "," + s2.charAt(j) + ")");
                i--;
                j--;
            } else if (i > 0 && op[i][j] == 2) {
                ops.addFirst("Delete(" + i + ")");
                i--;
            } else if (j > 0 && op[i][j] == 3) {
                ops.addFirst("Insert(" + i + "," + s2.charAt(j) + ")");
                j--;
            }
        }

        for (String line : ops) System.out.println(line);
    }
}

/*
Input 1:
6 5
sunday
satur
Output 1:
       0   1   2   3   4   5
   0   0   1   2   3   4   5
   1   1   1   2   3   4   5
   2   2   2   1   2   3   4
   3   3   3   2   2   3   4
   4   4   4   3   3   3   4
   5   5   5   4   4   4   4
   6   6   6   5   5   5   5
5
Replace(3,t)
Replace(4,u)
Delete(6)

Input 2:
4 4
abcd
abcf
Output 2:
       0   1   2   3   4
   0   0   1   2   3   4
   1   1   0   1   2   3
   2   2   1   0   1   2
   3   3   2   1   0   1
   4   4   3   2   1   1
1
Replace(4,f)

Input 3:
3 6
abc
abcdef
Output 3:
       0   1   2   3   4   5   6
   0   0   1   2   3   4   5   6
   1   1   0   1   2   3   4   5
   2   2   1   0   1   2   3   4
   3   3   2   1   0   1   2   3
3
Insert(3,d)
Insert(4,e)
Insert(5,f)
*/
