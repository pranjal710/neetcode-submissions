class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null || t == null) {
            return false;
        } else {
            char[] sA = s.toCharArray();
            char[] tA = t.toCharArray();
            Arrays.sort(sA);
            Arrays.sort(tA);
            System.out.println(sA);
            System.out.println(tA);
            return sA.length == tA.length && compare(sA, tA);
        }
    }

    private boolean compare(char[] sA, char[] tA) {
        for(int i = 0 ; i < sA.length; i++) {
            if(sA[i] != tA[i]) {
                return false;
            }
        }
        return true;
    }
}
