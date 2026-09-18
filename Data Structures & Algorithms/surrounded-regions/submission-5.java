class Solution {

    private boolean withinLimits(char[][] board, int i, int j) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }

    private void check(char[][] board, int i, int j) {
        if(!withinLimits(board, i, j)) {
            return;
        } else if(board[i][j] != 'O') {
            return;
        } else {
            board[i][j] = '-';
            check(board, i+1, j);
            check(board, i-1, j);
            check(board, i, j+1);
            check(board, i, j-1);
        }
    }

    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        for(int i = 0 ; i < board.length; i++) {
            check(board, i, 0);
            check(board, i, board[i].length-1);
        }

        for(int j = 0 ; j < board[0].length; j++) {
            check(board, 0, j);
            check(board, board.length-1, j);
        }

    // for(int i = 0 ; i < board.length; i++) {
    //         for(int j = 0 ; j < board[i].length; j++) {
    //             System.out.print(board[i][j] + " ");
    //         }
    //         System.out.println();
    //     }

        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ; j < board[i].length; j++) {
                if(board[i][j] == '-') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
