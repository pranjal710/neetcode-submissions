class Solution {
    public String longestPalindrome(String s) {
        int start = -1, end = -1, maxLength = -1;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0 ; i < s.length(); i++) {
            dp[i][i] = 1;
            if(maxLength < 1) {
                        start = i;
                        end = i;
                        maxLength = 1;
                    }
            if(i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
                dp[i][i+1] =  1 ;
                if(maxLength < 2) {
                        start = i;
                        end = i+1;
                        maxLength = 2;
                    }
            }
        }

        for(int i = s.length() - 3; i >= 0; i--) {
            for(int j = i + 2; j < s.length(); j++) {
                
                if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1] > 0) {
                    
                    dp[i][j] = dp[i+1][j-1] + 1;
                    System.out.println(j+"**"+i);
                    if(j-i+1 > maxLength) {
                        start = i;
                        end = j;
                        maxLength = j - i +1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

for(int i = 0 ; i < s.length(); i++){
    for(int j = 0 ; j < s.length(); j++) {
        System.out.print(dp[i][j] + " ");
    }
    System.out.println(" ");
}
System.out.println(start + " " + end);

        if(start == -1) {
            return "";
        }
        return s.substring(start, end+1);
    }
}
