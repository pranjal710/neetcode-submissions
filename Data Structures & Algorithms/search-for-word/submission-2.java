class Solution {
    public boolean exist(char[][] board, String word) {
        boolean ret = false;
        for(int i = 0 ; i < board.length; i++) {
            for(int j = 0 ; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)) {
                    ret = ret || backtrack(i, j, board, 0, word);
                }
            }
        }
        return ret;
    }

    private boolean withinLimits(int i, int j, char[][] board) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }

    public boolean backtrack(int i, int j, char[][] board, int curr, String word) {
        if(curr == word.length()) {
            return true;
        } else if(!withinLimits(i, j, board)) {
            return false;
        } else if(board[i][j] == '-') {
            return false;
        }else if(word.charAt(curr) != board[i][j]) {
            return false;
        } else {
            char tmp = board[i][j];
            board[i][j] = '-';
            boolean res = backtrack(i+1, j, board, curr+1, word)
            ||  backtrack(i-1, j, board, curr+1, word)
            ||  backtrack(i, j+1, board, curr+1, word)
            || backtrack(i, j-1, board, curr+1, word)
            ;
            board[i][j] = tmp;
            return res;
        }
    }
}
