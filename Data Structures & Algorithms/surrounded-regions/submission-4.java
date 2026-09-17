class Solution {
/*
[
    ["X","O","X","O","X","O"],
    ["O","X","O","X","O","X"],
    ["X","O","X","O","X","O"],
    ["O","X","O","X","O","X"]
]

[
    ["X","O","X","O","X","O"],
    ["O","X","X","X","X","X"],
    ["X","X","X","X","X","O"],
    ["O","X","O","X","O","X"]
]

[
    ["X","A","X","A","X","A"],
    ["A","X","O","X","O","X"],
    ["X","O","X","A","X","O"],
    ["A","X","A","X","A","X"]
]
*/
    public void solve(char[][] board) {
        if(board.length == 0) {
            return;
        }
        for(int j = 0 ; j < board[0].length; j++) {
            if(board[0][j] == 'O') {
                update(board, 0, j);
            }
            if(board[board.length - 1][j] == 'O') {
                update(board, board.length-1, j);
            }
        }

        for(int i = 0 ; i < board.length; i++) {
             if(board[i][0] == 'O') {
                 update(board, i, 0);
             }
            if(board[i][board[i].length - 1] == 'O') {
                update(board, i, board[i].length-1);
            }
        }

         for(int i = 0 ; i < board.length ; i++) {
             for(int j = 0 ; j < board[i].length; j++) {
                 if(board[i][j] == 'O') {
                     board[i][j] = 'X';
                 } else if (board[i][j] == 'A') {
                     board[i][j] = 'O';
                 }
             }
         }
        
    }

    private void update(char[][] board, int i, int j) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != 'O') {
            return;
        } else {
            board[i][j] = 'A';
            update(board, i + 1, j);
            update(board, i - 1, j);
            update(board, i, j + 1);
            update(board, i, j - 1);
        }
    }
}
