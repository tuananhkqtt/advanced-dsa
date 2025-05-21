package p02_enumeration.p13_generation_print_binary_sequence1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        char[] a = new char[n];
        for (int i = 0; i < n; i++)
            a[i] = '0';
            
        while (true) {
            System.out.println(a);
            int i = n - 1;
            while (i >= 0 && a[i] == '1') {
                a[i] = '0';
                i--;
            }
            if (i < 0)
                break;
            a[i] = '1';
        }
    }
}
