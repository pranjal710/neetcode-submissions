class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int leftx = 0, lefty = 0, rightx = matrix.length -1, righty = matrix[0].length -1;
        // System.out.println(leftx + " " + lefty + " | " + rightx + " " + righty );
        while(getIndex(new int[]{leftx, lefty},matrix) <= getIndex(new int[]{rightx, righty},matrix)) {
            if(target < matrix[leftx][lefty] || target > matrix[rightx][righty]) {
               return false;
            } else {
                int[] mid = getMid(new int[]{leftx, lefty}, new int[]{rightx, righty}, matrix);
                System.out.println(leftx + " " + lefty + " | " + rightx + " " + righty + " | " + mid[0] + " " + mid[1]);
                if(matrix[mid[0]][mid[1]] == target || matrix[leftx][lefty] == target || matrix[rightx][righty] == target) {
                    return true;
                } else if(matrix[mid[0]][mid[1]] > target) {
                    int[] right = getCoord(getIndex(mid,matrix) - 1, matrix);
                    rightx = right[0];
                    righty = right[1];
                } else {
                    int[] left = getCoord(getIndex(mid,matrix) + 1, matrix);
                    leftx = left[0];
                    lefty = left[1];
                }
            }
        }
        return false;
    }

    private int[] getMid(int[] left, int[] right, int[][] matrix) {
        int leftIndex = getIndex(left,matrix);
        int rightIndex = getIndex(right,matrix);
        int mid = leftIndex + ((rightIndex-leftIndex)/2);
        return getCoord(mid, matrix);
    }

    private int getIndex(int[] coord, int[][] matrix) {
        int x = coord[0];
        int len = matrix[coord[0]].length;
        int y = coord[1];
        return x*len + y;
    }

    private int[] getCoord(int index, int[][] matrix) {
        return new int[]{index/matrix[0].length, index%matrix[0].length};
    }
}
