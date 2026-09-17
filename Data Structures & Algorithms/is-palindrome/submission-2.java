class Solution {
    public boolean isPalindrome(String input) {
        //String s = input.replace(" ", "");
        //System.out.println(s);
        int start = 0, end = input.length() -1;
        while(start < end) {
            if(!isAlphaNumeric(start, input)) {
                start++;
            } else if(!isAlphaNumeric(end, input)) {
                end--;
            } else {
                if(
                    (input.charAt(start) == input.charAt(end))
                    || (
                        isChar(input.charAt(start)) && isChar(input.charAt(end))
                        && ((input.charAt(start) - 'A' == input.charAt(end) - 'a') || (input.charAt(start) - 'a' == input.charAt(end) - 'A'))
                    )
                ) {
                    System.out.println(input.charAt(start));
                    System.out.println(input.charAt(end));
                    System.out.println(start);
                    System.out.println(end);
                    start++;
                    end--;
                } else {
                    return false;
                }
                
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(int i, String s) {
        return 
        (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
        (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
        (s.charAt(i) >= '0' && s.charAt(i) <= '9');
    }

    public boolean isChar(char ch) {
        return 
        (ch >= 'a' && ch <= 'z') ||
        (ch >= 'A' && ch <= 'Z');
    }
}
