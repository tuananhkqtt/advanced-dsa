package p02_enumeration.p15_generation_combination1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();
        int[] comb = new int[k];
        for (int i = 0; i < k; i++) {
            comb[i] = i + 1;
        }
        while (true) {
            for (int i = 0; i < k; i++) {
                System.out.print(comb[i]);
                if (i < k - 1)
                    System.out.print(" ");
            }
            System.out.println();
            int i = k - 1;
            while (i >= 0 && comb[i] == n - k + i + 1) {
                i--;
            }
            if (i < 0)
                break;
            comb[i]++;
            for (int j = i + 1; j < k; j++) {
                comb[j] = comb[j - 1] + 1;
            }
        }
    }
}
