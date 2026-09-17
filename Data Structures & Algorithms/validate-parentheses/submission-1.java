class Solution {
    public boolean complimentOf(char inStack, char curr) {
        switch (curr) {
            // case '(' : return ')';
            // case '{' : return '}';
            // case '[' : return ']';
            case ')' : return '(' == inStack;
            case '}' : return '{' == inStack;
            case ']' : return '[' == inStack;
            default: return false;
        }
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int index = 0;
        while(index < s.length()) {
            char ch = s.charAt(index++);
            if(st.size() > 0 && complimentOf(st.peek(), ch)) {
                st.pop();
            } else {
                st.push(ch);
            }
        }
        return st.size() == 0;
    }
}
