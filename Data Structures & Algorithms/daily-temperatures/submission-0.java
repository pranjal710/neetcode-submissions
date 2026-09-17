class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int popped = 0;
        int[] res = new int[temperatures.length];
        for(int i = 0 ; i < temperatures.length; i++) {
            if(st.size() == 0) {
                st.push(i);
            } else {
                while(st.size() > 0 && temperatures[st.peek()] < temperatures[i]) {
                    int lastIndex = st.pop();
                    res[lastIndex] = i - lastIndex;
                }
                st.push(i);
            }
        }
        return res;     
    }
}
