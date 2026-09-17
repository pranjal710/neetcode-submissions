class Solution {
    public int getIndex (char ch) {
        return ch - 'A';
    }
    public int characterReplacement(String s, int k) {
        int[] counter = new int[26];
        int allCharCount = 0;
        int maxCountChar = 0;
        int longestLength = 0;
        int left = 0, right = -1;
        
        while(right < s.length()-1) {
            right++;
            allCharCount++;
            char ch = s.charAt(right);
            int index = getIndex(ch);
            counter[index] += 1;
            maxCountChar = Math.max(counter[index], maxCountChar);
            if(allCharCount-maxCountChar <= k) {
                longestLength = Math.max(allCharCount, longestLength); 
                // longestLength = right - left + 1;
                System.out.println("1 " + left + " " + right + " " + longestLength + " " + counter[index] + " " + allCharCount + " " + maxCountChar);
            } else {
                //while(allCharCount-maxCountChar > k) {
                    left++;
                    allCharCount--;
                    counter[getIndex(s.charAt(left-1))] -= 1;
                    //maxCountChar = Math.max(counter[getIndex(s.charAt(left))], maxCountChar);
                    System.out.println("2 " + left + " " + right + " " + longestLength + " " + counter[getIndex(s.charAt(left))] + " " + allCharCount + " " + maxCountChar);
                //}
                // longestLength = Math.max(allCharCount, longestLength); 
            }
        }
        
        return longestLength;
    }
}
