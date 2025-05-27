package p04_greedy.p02_money_exchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int[] coins = { 500, 100, 50, 10, 5, 1 };
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int change = 1000 - n;
            int cnt = 0;
            for (int c : coins) {
                cnt += change / c;
                change %= c;
            }
            System.out.println(cnt);
        }
    }
}
