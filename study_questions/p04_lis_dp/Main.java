package study_questions.p04_lis_dp;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) A[i] = sc.nextInt();

        int[] dp = new int[n];
        int[] trace = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(trace, -1);

        for (int i = 1; i < n; i++) {
            System.out.println("Xét phần tử A[" + i + "] = " + A[i]);
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    trace[i] = j;
                    System.out.println("  Cập nhật: dp[" + i + "] = " + dp[i] + ", trace[" + i + "] = " + j);
                }
            }
        }

        System.out.println("Mảng dp:");
        System.out.println(Arrays.toString(dp));
        System.out.println("Mảng trace:");
        System.out.println(Arrays.toString(trace));

        int maxLen = 0, endIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                endIndex = i;
            }
        }

        System.out.println("Chiều dài dãy con tăng dài nhất: " + maxLen);
        System.out.println("Truy vết dãy con:");

        List<Integer> lis = new ArrayList<>();
        while (endIndex != -1) {
            lis.add(A[endIndex]);
            System.out.println("  Thêm A[" + endIndex + "] = " + A[endIndex] + " vào kết quả");
            endIndex = trace[endIndex];
        }

        Collections.reverse(lis);

        System.out.print("Dãy con tăng: ");
        for (int x : lis) System.out.print(x + " ");
        System.out.println();
    }
}

/*
Ví dụ 1:
Input:
6
5 1 6 2 3 7
Output:
Xét phần tử A[1] = 1
Xét phần tử A[2] = 6
  Cập nhật: dp[2] = 2, trace[2] = 0
Xét phần tử A[3] = 2
  Cập nhật: dp[3] = 2, trace[3] = 1
Xét phần tử A[4] = 3
  Cập nhật: dp[4] = 3, trace[4] = 3
Xét phần tử A[5] = 7
  Cập nhật: dp[5] = 4, trace[5] = 4
Mảng dp:
[1, 1, 2, 2, 3, 4]
Mảng trace:
[-1, -1, 0, 1, 3, 4]
Chiều dài dãy con tăng dài nhất: 4
Truy vết dãy con:
  Thêm A[5] = 7 vào kết quả
  Thêm A[4] = 3 vào kết quả
  Thêm A[3] = 2 vào kết quả
  Thêm A[1] = 1 vào kết quả
Dãy con tăng: 1 2 3 7

Ví dụ 2:
Input:
8
10 9 2 5 3 7 101 18

Ví dụ 3:
Input:
5
3 4 2 1 10
*/
