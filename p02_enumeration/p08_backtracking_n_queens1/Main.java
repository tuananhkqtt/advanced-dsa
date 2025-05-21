package p02_enumeration.p08_backtracking_n_queens1;

import java.io.*;
import java.util.Scanner;

public class Main {
    static int n, solutionCount = 0;
    static int[] queen;        // queen[col] = row
    static boolean[] usedRow;
    static boolean[] usedDiag1;
    static boolean[] usedDiag2;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        queen     = new int[n + 1];
        usedRow   = new boolean[n + 1];
        usedDiag1 = new boolean[2 * n + 1]; // d1[2]=[{1, 1}]
        usedDiag2 = new boolean[2 * n + 1]; // d2[1]=[{1, n}]

        backtrack(1);

        // Viết toàn bộ kết quả ra stdout chỉ 1 lần
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
    }

    static void backtrack(int col) {
        if (col > n) {
            solutionCount++;
            // Gom vào StringBuilder
            sb.append("Solution ")
              .append(String.format("%2d", solutionCount))
              .append(":");
            for (int c = 1; c <= n; c++) {
                sb.append(" ")
                  .append(String.format("%2d", queen[c]));
            }
            sb.append('\n');
        } else {
            for (int row = 1; row <= n; row++) {
                int d1 = row + col;
                int d2 = row - col + n;
                if (!usedRow[row] && !usedDiag1[d1] && !usedDiag2[d2]) {
                    queen[col]   = row;
                    usedRow[row] = true;
                    usedDiag1[d1]= true;
                    usedDiag2[d2]= true;

                    backtrack(col + 1);

                    usedRow[row] = false;
                    usedDiag1[d1]= false;
                    usedDiag2[d2]= false;
                }
            }
        }
    }
}
