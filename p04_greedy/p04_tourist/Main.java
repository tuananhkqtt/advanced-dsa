package p04_greedy.p04_tourist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(parts[j]);
            }
        }
        boolean[] used = new boolean[n];
        List<Integer> path = new ArrayList<>();
        int cur = 0;
        used[cur] = true;
        path.add(cur);
        long total = 0;

        for (int step = 1; step < n; step++) {
            int best = -1, bestDist = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (!used[j] && a[cur][j] < bestDist) {
                    bestDist = a[cur][j];
                    best = j;
                }
            }
            used[best] = true;
            total += bestDist;
            cur = best;
            path.add(cur);
        }

        // quay về 1
        // total += a[cur][0];
        path.add(0);
        // xuất kết quả
        System.out.println("Tong chi phi=" + total);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.size() - 1; i++) {
            int u = path.get(i), v = path.get(i + 1);
            sb.append(u == 0 ? u + 1 : "").append("->").append(v + 1).append("(").append(a[u][v]).append(")");
            // if (i < path.size() - 2)
            // sb.append("->");
        }
        System.out.println(sb.toString());
    }
}
