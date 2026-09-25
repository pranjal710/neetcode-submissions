class Solution {
    private List<String> convert(List<List<String>> ret) {
        // List<String> res = new ArrayList<>();
        return ret.stream()
        .filter(x -> x != null)
        .filter(x -> x.size() > 0)
        .map(x -> makeString(x))
        .collect(Collectors.toList());
        
        // return res;
    }

    private String makeString(List<String> inp) {
        StringBuilder sb = new StringBuilder();
        for(int i = inp.size() - 1; i >= 0 ; i--) {
            sb.append(inp.get(i));
        }
        System.out.println(sb);
        return sb.toString();
    }

    public List<String> generateParenthesis(int n) {
        List<List<String>> res = backtrack(n, n);
        System.out.println(res);
        return convert(res);
    }

    private List<List<String>> backtrack(int left, int right) {
        if(right < left || right < 0 || left < 0) {
            return null;
        } else if (right == left && left == 0) {
            List<List<String>> ret = new ArrayList<>();
            ret.add(new ArrayList<>());
            return ret;
        } else if (right == left) {
            List<List<String>> ret = backtrack(left-1, right);
            ret = addToAll(ret, "(");
            return ret;
        } else {
            List<List<String>> leftRet = backtrack(left-1, right);
            List<List<String>> rightRet = backtrack(left, right-1);
            leftRet = addToAll(leftRet, "(");
            rightRet = addToAll(rightRet, ")");
            List<List<String>> ret = new ArrayList<>();
            if(leftRet != null)
                ret.addAll(leftRet);
            if(rightRet != null)
                ret.addAll(rightRet);
            return ret;
        }
    }

    private List<List<String>> addToAll(List<List<String>> ret, String toAdd) {
        if(ret == null) {
            return null;
        } else {
            return ret.stream()
            .filter(x -> x != null)
            .peek(x -> x.add(toAdd))
            .collect(Collectors.toList());
        }
    }
}
