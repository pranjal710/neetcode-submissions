class Solution {
    public char complimentOf(char ch) {
        switch (ch) {
            case '(' : return ')';
            case '{' : return '}';
            case '[' : return ']';
            case ')' : return '(';
            case '}' : return '{';
            case ']' : return '[';
            default: return '_';
        }
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()) {
            if(stack.size() == 0) {
                if((ch == '(') || (ch == '{') || (ch == '[') ) {
                    stack.push(ch);
                } else {
                    return false;
                }
            } else {
                if((ch == '(') || (ch == '{') || (ch == '[') ) {
                    stack.push(ch);
                } else {
                    if(complimentOf(ch) == stack.peek()) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }
}
