class Solution {
    public int numDistinct(String s, String t) {
        return getCount(s, 0, t, 0);
    }


    public int getCount(String s, int s1, String t, int t1) {
        int total = 0;
        if(s1 == s.length() && t1 != t.length()) {
            return 0;
        } else if (t1 == t.length()) {
            return 1;
        }
        // for(int i = s1; i < s.length(); i++) {
            if(s.charAt(s1) == t.charAt(t1)) {
                total = total + getCount(s, s1+1, t, t1+1);
            } 
                total += getCount(s, s1+1, t, t1);
            
        // }
        System.out.println(s1 + " " + t1 + " " + total);
        return total;
    }
}
