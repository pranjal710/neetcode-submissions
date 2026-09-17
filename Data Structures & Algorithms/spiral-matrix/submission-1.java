class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int left = 0, right = matrix[0].length-1, top = 0, bottom = matrix.length-1, nums = 0, total = (matrix[0].length)*(matrix.length);
        List<Integer> result = new ArrayList<>();
        while(nums < total) {
            for(int i = left; i <= right && nums < total; i++) {
                nums++;
                System.out.println("1");
                System.out.println(top + " " + i);
                result.add(matrix[top][i]);
            }

            for(int i = top+1; i < bottom && nums < total; i++) {
                nums++;
                System.out.println("2");
                System.out.println(i + " " + right);
                result.add(matrix[i][right]);
            }

            for(int i = right; i >= left && nums < total; i--) {
                nums++;
                System.out.println("3");
                System.out.println(bottom + " " + i);
                result.add(matrix[bottom][i]);
            }

            for(int i = bottom-1; i > top && nums < total; i--) {
                nums++;
                System.out.println("4");
                System.out.println(i + " " + left);
                result.add(matrix[i][left]);
            }
            left++;
            right--;
            top++;
            bottom--;
            System.out.println(left + " " + right + " " + top + " " + bottom);
// break;

            
        }
        return result;

    }
}
