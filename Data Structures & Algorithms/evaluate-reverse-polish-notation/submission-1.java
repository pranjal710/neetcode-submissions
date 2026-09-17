class Solution {
    Set<String> operand = new HashSet<>();

    public Solution() {
        operand.add("+");
        operand.add("-");
        operand.add("*");
        operand.add("/");
    }

    public int operate(int a, int b, String ch) {
        switch (ch) { 
            case "+" : return a+b;
            case "-" : return a-b;
            case "*" : return a*b;
            case "/" : return a/b;
            default: return 0;
        }
    }

    public boolean isOperand(String s) {
        return operand.contains(s);
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < tokens.length; i++) {
            if(!isOperand(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int second = stack.pop();
                int first = stack.pop();
                stack.push(operate(first, second, tokens[i]));
            }
        }
        return stack.size() == 0 ? 0 : stack.pop();
    }
}
