class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        return getSorted(s).equals(getSorted(t));
    }

    public String getSorted(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
}
