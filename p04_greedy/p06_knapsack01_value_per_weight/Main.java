package p04_greedy.p06_knapsack01_value_per_weight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Main {
    static class Item {
        int idx, w, v;
        double ratio;

        Item(int idx, int w, int v) {
            this.idx = idx;
            this.w = w;
            this.v = v;
            this.ratio = (double) v / w;
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
            int w = Integer.parseInt(wa[i]);
            int v = Integer.parseInt(va[i]);
            items[i] = new Item(i + 1, w, v);
        }
        Arrays.sort(items, (a, b) -> {
            if (b.ratio != a.ratio)
                return Double.compare(b.ratio, a.ratio);
            return a.idx - b.idx;
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
            String r = String.format(Locale.US, "%.2f", it.ratio).replace('.', ',');
            sb.append(it.idx)
                    .append("(")
                    .append(it.w).append("-")
                    .append(it.v).append("-")
                    .append(r)
                    .append(");");
        }
        System.out.println(sb.toString());
    }
}
