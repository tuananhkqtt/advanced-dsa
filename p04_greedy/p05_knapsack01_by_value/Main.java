package p04_greedy.p05_knapsack01_by_value;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static class Item {
        int idx, w, v;

        Item(int idx, int w, int v) {
            this.idx = idx;
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().trim().split("\\s+");
        int n = Integer.parseInt(first[0]);
        int W = Integer.parseInt(first[1]);
        String[] wa = br.readLine().trim().split("\\s+");
        String[] va = br.readLine().trim().split("\\s+");
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(i + 1, Integer.parseInt(wa[i]), Integer.parseInt(va[i]));
        }
        Arrays.sort(items, (a, b) -> {
            if (b.v != a.v)
                return b.v - a.v;
            return a.w - b.w;
        });
        int totalW = 0, totalV = 0;
        List<Item> picked = new ArrayList<>();
        for (Item it : items) {
            if (totalW + it.w <= W) {
                totalW += it.w;
                totalV += it.v;
                picked.add(it);
            }
        }
        System.out.println("Tong trong luong =" + totalW);
        System.out.println("Tong gia tri =" + totalV);
        StringBuilder sb = new StringBuilder();
        for (Item it : picked) {
            sb.append(it.idx).append("(").append(it.w).append(",").append(it.v).append(");");
        }
        System.out.println(sb.toString());
    }
}
