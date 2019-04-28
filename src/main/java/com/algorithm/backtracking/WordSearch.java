package com.algorithm.backtracking;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid. he word can be constructed
 * from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.startsWith(String.valueOf(board[i][j]))) {
                    if (backTrack(board, word, i, j, String.valueOf(board[i][j]))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean backTrack(char[][] board, String word, int i, int j, String chosen) {
        if (chosen.equals(word)) {
            return true;
        } else if (chosen.length() >= word.length() || !word.startsWith(chosen)) {
            return false;
        }

        board[i][j] ^= 256;
        if (i < board.length - 1) {
            if (backTrack(board, word, i + 1, j, chosen + board[i + 1][j])) {
                return true;
            }
        }

        if (i > 0) {
            if (backTrack(board, word, i - 1, j, chosen + board[i - 1][j])) {
                return true;
            }
        }
        if (j < board[i].length - 1) {
            if (backTrack(board, word, i, j + 1, chosen + board[i][j + 1])) {
                return true;
            }
        }

        if (j > 0) {
            if (backTrack(board, word, i, j - 1, chosen + board[i][j - 1])) {
                return true;
            }
        }
        board[i][j] ^= 256;
        return false;
    }

    public static void main(String[] args) {
        WordSearch ws = new WordSearch();
        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
       // char[][] board = {{'a', 'a'}};
        System.out.println(ws.exist(board, "ABCCED"));
    }
}
