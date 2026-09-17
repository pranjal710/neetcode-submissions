class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        dfs(s, 0, "", new ArrayList<>(), res);
        return res;
    }

    private boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return false;
        } else {
            char[] inp = s.toCharArray();
            int l = 0 , r = inp.length-1;
            while(l < r) {
                if(inp[l] != inp[r]) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

    private void dfs(String s, int index, String running, List<String> current, List<List<String>> res) {
        if(index == s.length() && running.length() == 0) {
            res.add(new ArrayList<>(current));
            
        } else if (index == s.length() && running.length() > 0) {
            if(isPalindrome(running)) {
                current.add(running);
                res.add(new ArrayList<>(current));
                current.remove(current.size()-1);
            }
        } else if(running.length() == 0) {
            dfs(s, index+1, "" + s.charAt(index), current, res);
            // current.remove(current.size()-1);
        } else {
            if(isPalindrome(running)) {
                current.add(running);
                dfs(s, index, "", current, res);
                current.remove(current.size()-1);
            } 
            dfs(s, index+1, running + s.charAt(index), current, res);
            // current.remove(current.size()-1);
        }
    }
}
