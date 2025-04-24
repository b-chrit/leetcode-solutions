class Solution {
    public boolean exist(char[][] board, String word) {
        int numberOfRows = board.length;
        int numberOfCols = board[0].length;

        if (word == null) return false;
        if (word.equals("")) return true;

        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfCols; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int index) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = dfs(board, word, row + 1, col, index + 1) ||
                        dfs(board, word, row - 1, col, index + 1) ||
                        dfs(board, word, row, col + 1, index + 1) ||
                        dfs(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }
}
