package p05_dynamic_programming.p01_longest_increasing_subsequence;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        long[] a = new long[n + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            a[i] = Long.parseLong(st.nextToken());
        }
        // Sentinel
        a[n + 1] = Long.MAX_VALUE;

        int[] L = new int[n + 2];
        int[] T = new int[n + 2];

        // Khởi tạo L[n+1]
        L[n + 1] = 1;
        out.println("L[" + (n + 1) + "]=1");

        // Tính DP
        for (int i = n; i >= 0; i--) {
            int jmax = n + 1;
            out.println("jmax=n+1=" + n + "+1=" + (n + 1));

            for (int j = i + 1; j <= n; j++) {
                if (a[j] > a[i] && L[j] > L[jmax]) {
                    out.println("i=" + i + ",j=" + j + ",jmax=" + jmax
                            + ",a[" + j + "]>a[" + i + "] &&L[" + j + "]>L[" + jmax + "]:");
                    jmax = j;
                }
            }
            L[i] = L[jmax] + 1;
            T[i] = jmax;
            out.println("jmax=j=" + jmax);
            out.println("L[" + i + "]=L[" + jmax + "]+1=" + L[i]);
            out.println("T[" + i + "]=jmax=" + jmax);
        }

        // Tìm độ dài LIS và vị trí bắt đầu
        int best = 1;
        for (int i = 2; i <= n; i++) {
            if (L[i] > L[best]) {
                best = i;
            }
        }

        // In dãy con tăng đơn điệu
        ArrayList<Integer> seq = new ArrayList<>();
        for (int u = best; u != n + 1; u = T[u]) {
            seq.add(u);
        }

        out.println(seq.size());

        for (int idx : seq) {
            out.print("a[" + idx + "]=" + a[idx] + ";");
        }
        out.println();

        out.flush();
    }
}
