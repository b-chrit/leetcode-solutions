class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && board[i][j] == 'O'){
                    markSafe(board, i, j);
                }
            }
        }
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                } else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void markSafe(char[][] board, int r, int c){
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        
        board[r][c] = 'S';
        
        markSafe(board, r + 1, c);
        markSafe(board, r - 1, c);
        markSafe(board, r, c + 1);
        markSafe(board, r, c - 1);
    }
}