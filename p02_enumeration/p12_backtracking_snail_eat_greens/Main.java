package p02_enumeration.p12_backtracking_snail_eat_greens;

import java.util.Scanner;

public class Main {
    static int n, m, startY, startX;
    static int[][] grid;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        startY = sc.nextInt() - 1;
        startX = sc.nextInt() - 1;
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        sc.close();
        visited = new boolean[n][m];
        dfs(startY, startX);
        System.out.println(count);
    }

    static void dfs(int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= m)
            return;
        if (visited[y][x] || grid[y][x] == 1)
            return;
        visited[y][x] = true;
        count++;
        dfs(y - 1, x);
        dfs(y + 1, x);
        dfs(y, x - 1);
        dfs(y, x + 1);
    }
}
