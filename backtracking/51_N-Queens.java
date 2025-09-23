// A queen in chess can move horizontally, vertically, and diagonally.
// - Horizontal/vertical: no two queens can share the same row or column.
//   We avoid row conflicts by placing exactly one queen per row, and we track used columns in a set.
// - Diagonal: a queen attacks along both diagonals. 
//   For any square (r, c):
//     * All squares on the same "\" diagonal (negative diagonal) share the same value of (r - c).
//     * All squares on the same "/" diagonal (positive diagonal) share the same value of (r + c).
//   We track these values in sets to quickly detect diagonal conflicts.
//
// Time Complexity: O(N!) in the worst case (placing N queens with backtracking).
// Space Complexity: O(N^2) for the board, plus O(N) for recursion and sets.

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        Set<Integer> cols = new HashSet<>();
        Set<Integer> posDiag = new HashSet<>();
        Set<Integer> negDiag = new HashSet<>();

        backtrack(0, n, board, result, cols, posDiag, negDiag);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, List<List<String>> result,
                           Set<Integer> cols, Set<Integer> posDiag, Set<Integer> negDiag) {
        if (row == n) {
            List<String> solution = new ArrayList<>();
            for (char[] r : board) {
                solution.add(new String(r));
            }
            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (cols.contains(col) || posDiag.contains(row + col) || negDiag.contains(row - col)) {
                continue;
            }

            board[row][col] = 'Q';
            cols.add(col);
            posDiag.add(row + col);
            negDiag.add(row - col);

            backtrack(row + 1, n, board, result, cols, posDiag, negDiag);

            board[row][col] = '.';
            cols.remove(col);
            posDiag.remove(row + col);
            negDiag.remove(row - col);
        }
    }
}
