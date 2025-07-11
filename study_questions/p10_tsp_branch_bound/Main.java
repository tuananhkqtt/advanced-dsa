package study_questions.p10_tsp_branch_bound;

import java.util.*;

public class Main {
    static int n;
    static int[][] dist;
    static boolean[] visited;
    static int minCost = Integer.MAX_VALUE;

    public static void tsp(int city, int count, int cost, int start) {
        if (count == n && dist[city][start] > 0) {
            minCost = Math.min(minCost, cost + dist[city][start]);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i] && dist[city][i] > 0) {
                visited[i] = true;
                tsp(i, count + 1, cost + dist[city][i], start);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = sc.nextInt();

        visited = new boolean[n];
        visited[0] = true;
        tsp(0, 1, 0, 0);
        System.out.println(minCost);
    }
}

/*
Input 1:
4
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0
Output 1:
80

Input 2:
3
0 5 8
5 0 10
8 10 0
Output 2:
23

Input 3:
5
0 14 4 10 20
14 0 7 8 7
4 5 0 7 16
11 7 9 0 2
18 7 17 4 0
Output 3:
30
*/
