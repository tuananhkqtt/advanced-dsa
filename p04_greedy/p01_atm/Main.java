package p04_greedy.p01_atm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    // Tiền đơn vị cơ bản: 1,2,3,5 (tương ứng 1000,2000,3000,5000)
    static final int[] COINS = { 1, 2, 3, 5 };
    // Với mỗi chữ số 0..9, lưu minimal coin count và số cách
    static int[] minCnt = new int[10];
    static BigInteger[] ways = new BigInteger[10];

    public static void main(String[] args) throws IOException {
        precompute();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String line;
            while ((line = br.readLine()) != null && line.trim().isEmpty())
                ;
            if (line == null)
                break;
            BigInteger W = new BigInteger(line.trim());
            int c = Integer.parseInt(br.readLine().trim());
            // Kiểm tra chia hết cho 1000
            BigInteger thousand = BigInteger.valueOf(1000);
            if (!W.mod(thousand).equals(BigInteger.ZERO)) {
                System.out.println(0);
                continue;
            }
            BigInteger Wp = W.divide(thousand);
            String s = Wp.toString();
            // Nếu độ dài quá c+1 chữ số, không thể đặt
            if (s.length() > c + 1) {
                System.out.println(0);
                continue;
            }
            // Xử lý các chữ số tại từng bậc 10^i
            s = new StringBuilder(s).reverse().toString();
            long totalN = 0;
            BigInteger totalS = BigInteger.ONE;
            boolean ok = true;
            for (int i = 0; i <= c; i++) {
                int d = i < s.length() ? s.charAt(i) - '0' : 0;
                if (ways[d].equals(BigInteger.ZERO)) {
                    ok = false;
                    break;
                }
                totalN += minCnt[d];
                totalS = totalS.multiply(ways[d]);
            }
            if (!ok) {
                System.out.println(0);
            } else {
                System.out.println(totalN + " " + totalS);
            }
        }
    }

    // DP nhỏ: tính với sum<=9
    static void precompute() {
        long[][] dp = new long[10][20];
        dp[0][0] = 1;
        for (int coin : COINS) {
            for (int d = coin; d <= 9; d++) {
                for (int k = 1; k < dp[d].length; k++) {
                    dp[d][k] += dp[d - coin][k - 1];
                }
            }
        }
        for (int d = 0; d <= 9; d++) {
            ways[d] = BigInteger.ZERO;
            for (int k = 0; k < dp[d].length; k++) {
                if (dp[d][k] > 0) {
                    minCnt[d] = k;
                    ways[d] = BigInteger.valueOf(dp[d][k]);
                    break;
                }
            }
        }
    }
}
