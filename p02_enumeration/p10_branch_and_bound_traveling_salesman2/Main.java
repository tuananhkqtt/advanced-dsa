package p02_enumeration.p10_branch_and_bound_traveling_salesman2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int n;
    static long[][] dist;
    static boolean[] visited;
    static int[] path;
    static long best = Long.MAX_VALUE;
    static List<int[]> solutions = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = sc.nextLong();
            }
        }
        sc.close();

        visited = new boolean[n];
        path = new int[n];
        for (int start = 0; start < n; start++) {
            visited[start] = true;
            path[0] = start;
            dfs(1, 0L, start);
            visited[start] = false;
        }

        System.out.println("Min total distance = " + best);
        int count = 1;
        for (int[] sol : solutions) {
            System.out.printf("Solution %2d: ", count++);
            for (int v : sol) {
                System.out.printf("%4d", v);
            }
            System.out.println();
        }
    }

    static void dfs(int pos, long cost, int start) {
        if (cost >= best) return;
        if (pos == n) {
            long total = cost + dist[path[n - 1]][start];
            if (total < best) {
                best = total;
                solutions.clear();
                solutions.add(path.clone());
            } else if (total == best) {
                solutions.add(path.clone());
            }
            return;
        }
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                visited[v] = true;
                path[pos] = v;
                dfs(pos + 1, cost + dist[path[pos - 1]][v], start);
                visited[v] = false;
            }
        }
    }
}
