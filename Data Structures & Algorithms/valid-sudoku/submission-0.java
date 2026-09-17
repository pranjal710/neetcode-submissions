class Solution {

    public boolean add(Set<Integer> numbers, char numChar) {
        return numChar == '.' || (numChar - '0' > 0 && numChar - '0' < 10 && numbers.add((numChar - '0')));
    }

    public boolean validateEachRow(char[][] board, int row) {
        Set<Integer> numbers = new HashSet<>();
        for(int col = 0 ; col < 9; col++) {
            if(!add(numbers, board[row][col])) {
                return false;
            }
        }
        return true;
    }

    public boolean validateRow(char[][] board) {
        boolean valid = true;
        for(int i = 0 ; i < board.length; i++) {
            valid = valid & validateEachRow(board, i);
        }
        return valid;
    }

    public boolean validateEachCol(char[][] board, int col) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = 0 ; i < 9; i++) {
            if(!add(numbers, board[i][col])) {
                return false;
            }
        }
        return true;
    }

    public boolean validateCol(char[][] board) {
        boolean valid = true;
        for(int i = 0 ; i < board.length; i++) {
            valid = valid & validateEachCol(board, i);
        }
        return valid;
    }

    public boolean validateEachSubGrid(char[][] board, int row, int col) {
        Set<Integer> numbers = new HashSet<>();
        for(int i = row; i < row + 3; i++) {
            for(int j = col; j < col + 3 ; j++) {
                if(!add(numbers, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean validateSubGrid(char[][] board) {
        int row = 0, col = 0;
        boolean valid = true;
        while(row < 9 && col < 9) {
            System.out.println(row +  " " + col);
            valid = valid & validateEachSubGrid(board, row, col);
            row += 3;
            if(row == 9) {
                row = 0;
                col += 3;
            }
        }
        return valid;
    }

    public boolean isValidSudoku(char[][] board) {
        return validateRow(board)
        && validateCol(board)
        && validateSubGrid(board);
    }
}