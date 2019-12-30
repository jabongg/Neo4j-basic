package com.datastructures.algorthims.backtracking;

public class SudokuSolver {
    /*
  Sudoku Solver - LeetCode: https://leetcode.com/problems/sudoku-solver/
  This code passes all Leetcode test cases as of Oct. 22nd 2019
*/

    private static final char EMPTY_ENTRY = '.';

    public static void solveSudoku(char[][] board) {
        canSolveSudokuFromCell(0, 0, board);
    }

    private static boolean canSolveSudokuFromCell(int row, int col, char[][] board) {
        if (col == board[row].length) {
            col = 0;
            row++;

            if (row == board.length) {
                return true;
            }
        }

        // Skip entries already filled out. They already have a value in them.
        if (board[row][col] != EMPTY_ENTRY) {
            return canSolveSudokuFromCell(row, col + 1, board);
        }

        for (int value = 1; value <= board.length; value++) {
            char charToPlace = (char) (value + '0');

            if (canPlaceValue(board, row, col, charToPlace)) {
                board[row][col] = charToPlace;
                if (canSolveSudokuFromCell(row, col + 1, board)) {
                    return true;
                }
                board[row][col] = EMPTY_ENTRY;
            }
        }

        return false;
    }

    private static boolean canPlaceValue(char[][] board, int row, int col, char charToPlace) {
        // Check column of the placement
        for (char[] placementRow: board) {
            if (charToPlace == placementRow[col]){
                return false;
            }
        }

        // Check row of the placement
        for (int i = 0; i < board[row].length; i++) {
            if (charToPlace == board[row][i]) {
                return false;
            }
        }

        // Check region constraints - get the size of the sub-box
        int regionSize = (int) Math.sqrt(board.length);

        int verticalBoxIndex = row / regionSize;
        int horizontalBoxIndex = col / regionSize;

        int topLeftOfSubBoxRow = regionSize * verticalBoxIndex;
        int topLeftOfSubBoxCol = regionSize * horizontalBoxIndex;

        for (int i = 0; i < regionSize; i++) {
            for (int j = 0; j < regionSize; j++) {
                if (charToPlace == board[topLeftOfSubBoxRow + i][topLeftOfSubBoxCol + j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};

        solveSudoku(board);

    }
}

