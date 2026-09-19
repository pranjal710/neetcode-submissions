class Solution {
    public int minDistance(String word1, String word2) {
        int[][] cache = new int[word1.length()][word2.length()];
        if(word1 == null || word2 == null) {
            return 0;
        } else {
            return backtrack(word1, 0, word2, 0, cache);
        }
    }

    private int backtrack(String word1, int w1Start, String word2, int w2Start, int[][] cache) {
        if(w1Start == word1.length()) {
            return word2.length() - w2Start;
        } else if(w2Start == word2.length()) {
            return word1.length() - w1Start;
        } else if (cache[w1Start][w2Start] > 0) {
            return cache[w1Start][w2Start];
        } else if (word1.charAt(w1Start) == word2.charAt(w2Start)) {
            cache[w1Start][w2Start] = backtrack(word1, w1Start+1, word2, w2Start +1, cache);
            return cache[w1Start][w2Start];
        } else {
            cache[w1Start][w2Start] = 1 + Math.min(
                Math.min(backtrack(word1, w1Start+1, word2, w2Start, cache), 
            backtrack(word1, w1Start, word2, w2Start+1, cache)), 
            backtrack(word1, w1Start+1, word2, w2Start+1, cache));
            return cache[w1Start][w2Start];
        }
    }
}
