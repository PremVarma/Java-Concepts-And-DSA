package ds.Recursion.hard;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

//CHESS -> EVERY ROW 1 Q , EVERY COL 1 Q and THEY SHOULD NOT ATTACK EACH OTHER ( QUEEN ATTACK IN ALL 8 DIRECTIONS ) --> CONSIDER 4*4 CHESS BOARD
public class NQueenProblem {
    public static void main(String[] args) {
        int N = 4;
        List<List<String>> queen = solveNQueensBF(N);
        int i = 1;
        for (List<String> it : queen) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

        List<List<String>> ans = solveNQueensOP(N);

        i = 1;
        for (List<String> it : ans) {
            System.out.println("Arrangement " + i);
            for (String s : it) {
                System.out.println(s);
            }
            System.out.println();
            i += 1;
        }

    }

    private static List<List<String>> solveNQueensOP(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';
        List<List<String>> res = new ArrayList<List<String>>();
        int leftRow[] = new int[n];
        int upperDiagonal[] = new int[2 * n - 1];
        int lowerDiagonal[] = new int[2 * n - 1];
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);
        return res;
    }


    static void solve(int col, char[][] board, List<List<String>> res, int leftRow[], int lowerDiagonal[], int upperDiagonal[]) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }

        for (int row = 0; row < board.length; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {
                board[row][col] = 'Q';
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }


    public static List<List<String>> solveNQueensBF(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                board[i][j] = '.';

        List<List<String>> res = new ArrayList<>();
        placeNQueenBF(0, board, res);
        return res;
    }

    private static void placeNQueenBF(int col, char[][] board, List<List<String>> res) {
        if (col == board.length) {
            res.add(construct(board));
            return;
        }
        for (int row = 0; row < board.length; row++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';
                placeNQueenBF(col + 1, board, res);
                board[row][col] = '.';
            }
        }
    }

    private static boolean isSafe(char[][] board, int row, int col) {

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 'Q')
                return false;

        for (int i = col; i >= 0; i--)
            if (board[row][i] == 'Q') return false;


        for (int i = row, j = col; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == 'Q') return false;
        }

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (char[] row : board)
            res.add(new String(row));
        return res;
    }

}



