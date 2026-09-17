class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;
        // int index = 0;
        Set<Character> uniqueChecker = new HashSet<>();
        while(right < s.length()) {
            if(uniqueChecker.add(s.charAt(right))) {
                maxLength = (right - left + 1) > maxLength ? (right - left + 1) : maxLength;
                right++;
            } else {
                char charInFocus = s.charAt(right);
                while(s.charAt(left) != charInFocus) {
                    uniqueChecker.remove(s.charAt(left));
                    left++;
                }
                uniqueChecker.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }
}
