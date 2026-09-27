class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        return backtrack(s, 0, cache);
    }

    private int backtrack(String s, int curr, int[] cache) {
        if(curr > s.length()) {
            return 0;
        } else if(curr == s.length()) {
            return 1;
        } else if(cache[curr] > 0) {
            return cache[curr];
        }
         else {
            char currChar = s.charAt(curr);
            if(currChar == '0') {
                return 0;
            } else if (Integer.parseInt(currChar + "") > 2) {
                cache[curr] = backtrack(s, curr + 1, cache);
            } else if(currChar == '1') {
                cache[curr] = backtrack(s, curr + 1, cache) + backtrack(s, curr + 2, cache);
            } else if(currChar == '2' && curr == s.length() -1) {
                cache[curr] = backtrack(s, curr+1, cache);
            } else if(Integer.parseInt("" + s.charAt(curr+1)) > 6) {
                cache[curr] = backtrack(s, curr+1, cache);
            } else {
                cache[curr] = backtrack(s, curr+1, cache) + backtrack(s, curr+2, cache);
            }
            return cache[curr];
        }
    }
}
