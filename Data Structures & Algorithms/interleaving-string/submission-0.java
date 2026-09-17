class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int[][] cache = new int[s3.length()+1][s3.length()+1];
        if(s3.length() != s1.length() + s2.length()) {
            return false;
        }
        return backtrack(s1, 0, s2, 0, s3, 0,cache);
    }

    private boolean matches(String s3, int s3index, String s1, int s1index) {
        return s1index < s1.length() && s3.charAt(s3index) == s1.charAt(s1index);
    }

    private boolean backtrack(String s1, int s1index, String s2, int s2index, String s3, int s3index, int[][] cache) {
        if(s3index == s3.length() && s1index == s1.length() && s2index == s2.length()) {
            return true;
        } else if(s3index == s3.length()) {
            return false;
        } else {
            if(cache[s1index][s2index] != 0) {
                return cache[s1index][s2index] == 1 ? true : false;
            }
            boolean match1 = false, match2 = false;
            if(matches(s3, s3index, s1, s1index)) {
                match1 = backtrack(s1, s1index+1, s2, s2index, s3, s3index+1, cache);
                // System.out.println(s1index + " " + s2index + " " + s3index + " " + (match1 || match2));
            }
            if(matches(s3, s3index, s2, s2index)) {
                match2 = backtrack(s1, s1index, s2, s2index+1, s3, s3index+1, cache);
            }
            cache[s1index][s2index] = (match1 || match2) ? 1 : 2;
            return (match1 || match2);
        }
    }
}