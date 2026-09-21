class Solution {
    private int max = 0;

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        return backtrack(text1, 0, text2, 0, cache);
        // return max;
    }

    private int backtrack(String text1, int text1Index, String text2, int text2Index, int[][] cache) {
        if(text1.length() == text1Index || text2.length() == text2Index) {
            return 0;
        } else if (cache[text1Index][text2Index] > 0) {
            return cache[text1Index][text2Index];
        } else if (text1.charAt(text1Index) == text2.charAt(text2Index)) {
            cache[text1Index][text2Index] = 1 + backtrack(text1, text1Index+1, text2, text2Index+1, cache);
            return cache[text1Index][text2Index];
        } else {
            cache[text1Index][text2Index] = Math.max(
                backtrack(text1, text1Index+1, text2, text2Index, cache), 
                backtrack(text1, text1Index, text2, text2Index+1, cache)
            );
            return cache[text1Index][text2Index];
        }
    }
}
