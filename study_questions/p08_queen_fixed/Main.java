package study_questions.p08_queen_fixed;

import java.util.*;

public class Main {
    static int[] pos = new int[9];
    static boolean[] usedCol = new boolean[9];
    static boolean[] diag1 = new boolean[17];
    static boolean[] diag2 = new boolean[17];
    static int fixedRow, fixedCol;

    public static void solve(int row) {
        if (row > 8) {
            for (int i = 1; i <= 8; i++) {
                System.out.print(pos[i]);
                if (i < 8) System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if (row == fixedRow) {
            solve(row + 1);
            return;
        }
        for (int col = 1; col <= 8; col++) {
            if (usedCol[col] || diag1[row - col + 8] || diag2[row + col]) continue;
            pos[row] = col;
            usedCol[col] = true;
            diag1[row - col + 8] = true;
            diag2[row + col] = true;
            solve(row + 1);
            usedCol[col] = false;
            diag1[row - col + 8] = false;
            diag2[row + col] = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fixedRow = sc.nextInt();
        fixedCol = sc.nextInt();
        pos[fixedRow] = fixedCol;
        usedCol[fixedCol] = true;
        diag1[fixedRow - fixedCol + 8] = true;
        diag2[fixedRow + fixedCol] = true;
        solve(1);
    }
}

/*
Input 1:
1 1
Output 1:
1 5 8 6 3 7 2 4

Input 2:
4 4
Output 2:
2 7 5 4 1 8 6 3
3 6 8 4 1 7 5 2
4 2 8 4 1 7 5 3
...

Input 3:
8 8
Output 3:
5 2 4 7 3 1 6 8
6 3 1 7 5 2 4 8
...
*/
