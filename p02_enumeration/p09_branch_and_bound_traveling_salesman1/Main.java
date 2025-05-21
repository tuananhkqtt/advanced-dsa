package p02_enumeration.p09_branch_and_bound_traveling_salesman1;

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] dist;
    static boolean[] visited;
    static int best = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }
        sc.close();
        visited = new boolean[n];
        visited[0] = true;
        dfs(0, 1, 0);
        System.out.println(best);
    }

    static void dfs(int u, int count, int cost) {
        if (cost >= best)
            return;
        if (count == n) {
            cost += dist[u][0];
            if (cost < best)
                best = cost;
            return;
        }
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                visited[v] = true;
                dfs(v, count + 1, cost + dist[u][v]);
                visited[v] = false;
            }
        }
    }
}
