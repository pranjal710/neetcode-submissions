class Solution {
    public boolean checkValidString(String s) {
        return recur(s, 0, 0, 0);
    }

    public boolean recur(String s, int index, int leftCount, int rightCount) {
        if(leftCount == rightCount && s.length() == index) {
            return true;
        } else if(rightCount > leftCount || (leftCount != rightCount && s.length() == index)) {
            return false;
        } else {
            char brace = s.charAt(index);
            if(brace == '(') {
                return recur(s, index+1, leftCount+1, rightCount);
            } else if(brace == ')') {
                return recur(s, index+1, leftCount, rightCount+1);
            } else {
                return recur(s, index+1, leftCount+1, rightCount)
                || recur(s, index+1, leftCount, rightCount+1) 
                || recur(s, index+1, leftCount, rightCount);
            }
        }
    }
}
