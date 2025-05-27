package p04_greedy.p03_tree_planting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] parts = br.readLine().trim().split("\\s+");
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(parts[i]);
        }
        Arrays.sort(t);
        // trồng cây có thời gian lớn trước
        long bestFinish = 0;
        for (int i = 0; i < n; i++) {
            long plantDay = i + 1;
            long finishDay = plantDay + t[n - 1 - i];
            bestFinish = Math.max(bestFinish, finishDay);
        }
        // party là ngày hôm sau
        System.out.println(bestFinish + 1);
    }
}
