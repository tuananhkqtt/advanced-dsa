package p02_enumeration.p11_backtracking_n_queens2;

import java.util.Scanner;

public class Main {
    static int[] queen = new int[9];
    static boolean[] usedCol = new boolean[9];
    static boolean[] usedDiag1 = new boolean[17];
    static boolean[] usedDiag2 = new boolean[15];
    static int fixedRow, fixedCol;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fixedRow = sc.nextInt();
        fixedCol = sc.nextInt();
        sc.close();
        queen[fixedRow] = fixedCol;
        usedCol[fixedCol] = true;
        usedDiag1[fixedRow + fixedCol] = true;
        usedDiag2[fixedRow - fixedCol + 7] = true;
        backtrack(1);
    }

    static void backtrack(int row) {
        if (row == 9) {
            for (int i = 1; i <= 8; i++) {
                System.out.print(queen[i] + " ");
            }
            System.out.println();
            return;
        }
        if (row == fixedRow) {
            backtrack(row + 1);
            return;
        }
        for (int col = 1; col <= 8; col++) {
            int d1 = row + col;
            int d2 = row - col + 7;
            if (!usedCol[col] && !usedDiag1[d1] && !usedDiag2[d2]) {
                queen[row] = col;
                usedCol[col] = true;
                usedDiag1[d1] = true;
                usedDiag2[d2] = true;
                backtrack(row + 1);
                usedCol[col] = false;
                usedDiag1[d1] = false;
                usedDiag2[d2] = false;
            }
        }
    }
}
