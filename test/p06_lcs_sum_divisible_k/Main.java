package test.p06_lcs_sum_divisible_k;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] A = new int[n + 1];
        for (int i = 1; i <= n; i++) A[i] = sc.nextInt();

        int[][] dp = new int[n + 1][k];
        int[][] prev = new int[n + 1][k];

        for (int i = 0; i <= n; i++) Arrays.fill(prev[i], -1);

        for (int i = 1; i <= n; i++) {
            int mod = A[i] % k;
            for (int r = 0; r < k; r++) {
                dp[i][r] = dp[i - 1][r];
                prev[i][r] = prev[i - 1][r];
            }

            for (int r = 0; r < k; r++) {
                int newR = (r + A[i]) % k;
                if (dp[i - 1][r] + 1 > dp[i][newR]) {
                    dp[i][newR] = dp[i - 1][r] + 1;
                    prev[i][newR] = r;
                }
            }

            if (dp[i][mod] < 1) {
                dp[i][mod] = 1;
                prev[i][mod] = -2;
            }
        }

        System.out.printf("%4s", "");
        for (int r = 0; r < k; r++) System.out.printf("%4d", r);
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.printf("%4d", i);
            for (int r = 0; r < k; r++) {
                System.out.printf("%4d", dp[i][r]);
            }
            System.out.println();
        }

        int maxLen = 0;
        int index = -1;
        for (int i = 1; i <= n; i++) {
            if (dp[i][0] > maxLen) {
                maxLen = dp[i][0];
                index = i;
            }
        }

        System.out.println("Length = " + maxLen);

        List<Integer> sequence = new ArrayList<>();
        int r = 0;
        while (index > 0 && dp[index][r] > 0) {
            int prevR = prev[index][r];
            if (prevR == -2) {
                sequence.add(A[index]);
                break;
            }
            if (dp[index][r] != dp[index - 1][r]) {
                sequence.add(A[index]);
                r = prevR;
            }
            index--;
        }

        Collections.reverse(sequence);
        for (int i = 0; i < sequence.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(sequence.get(i));
        }
        System.out.println();

        int total = 0;
        for (int x : sequence) total += x;
        System.out.println("Sum = " + total);
    }
}

/*
Input 1:
6 5
1 2 3 4 5 6
Output 1:
       0   1   2   3   4
   0   0   0   0   0   0
   1   0   1   0   0   0
   2   0   1   1   0   0
   3   0   1   1   2   0
   4   1   1   1   2   2
   5   2   1   1   2   2
   6   2   2   1   2   3
Length = 2
4 1
Sum = 5

Input 2:
7 3
3 1 4 1 5 9 2
Output 2:
       0   1   2
   0   0   0   0
   1   1   0   0
   2   1   1   0
   3   1   1   2
   4   1   2   2
   5   2   2   2
   6   3   2   2
   7   3   3   2
Length = 3
3 4 2
Sum = 9

Input 3:
5 4
2 6 4 1 7
Output 3:
       0   1   2   3
   0   0   0   0   0
   1   0   0   1   0
   2   0   0   1   1
   3   1   0   1   1
   4   1   1   1   1
   5   1   2   1   1
Length = 1
4
Sum = 4
*/
