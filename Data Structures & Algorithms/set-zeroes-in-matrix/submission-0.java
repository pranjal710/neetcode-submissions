class Solution {
    private void setRowAsZero(int[][] matrix, int row){
        for(int i = 0 ; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
    }

    private void setColAsZero(int[][] matrix, int col){
        for(int i = 0 ; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean firstRowSetZero = false, firstColSetZero = false;
        for(int i = 0 ; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                firstColSetZero = true;
            }
        }
        for(int i = 0 ; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                firstRowSetZero = true;
            }
        }

        for(int i = 0 ; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
            System.out.println(" ");
        }

        for(int i = 1 ; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                setRowAsZero(matrix, i);
            }
        }
        for(int i = 1 ; i < matrix[0].length; i++) {
            if(matrix[0][i] == 0) {
                setColAsZero(matrix, i);
            }
        }
        if(firstRowSetZero) {
            setRowAsZero(matrix, 0);
        }
        if(firstColSetZero) {
            setColAsZero(matrix, 0);
        }

    }
}
