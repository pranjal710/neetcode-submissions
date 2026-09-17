class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, n, res, "");
        return res;
    }

    private int count = 0;

    public void dfs(int left, int right, int k, List<String> result, String soFar) {
        if(left == k && right < k) {
            System.out.println("1" + soFar);
            dfs(left, right+1, k, result, soFar+")");
        }else if(left == k && right ==k) {
            System.out.println("2" + soFar);
            result.add(soFar);
        } else if(left == 0 || left == right) {
            System.out.println("3" + soFar);
            dfs(left+1, right, k, result, soFar + "(");
        } else {
            System.out.println("4" + soFar);
            dfs(left+1, right, k, result, soFar + "(");
            dfs(left, right+1, k, result, soFar + ")");
        }
    }
}
