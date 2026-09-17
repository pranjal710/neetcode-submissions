class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0) {
            return 0;
        }
        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(s.length(), 1);
        return recur(s, 0, cache);
    }

    private boolean isValid(String str) {
        return (str.charAt(0) != '0' && Integer.parseInt(str) < 27 && Integer.parseInt(str) > 0);
    }

    private List<Integer> getChildren(String s, int start) {
        List<Integer> result = new ArrayList<>();
        for(int i = 1; i+start <= s.length();i++) {
            if(isValid(s.substring(start, start+i))) {
                result.add(i+start);
            } else {
                return result;
            }
        }
        return result;
    }

    public int recur(String s, int start, Map<Integer, Integer> cache) {
        if(cache.containsKey(start)) {
            return cache.get(start);
        } else {
            int total = 0;
            List<Integer> nextInt = getChildren(s, start);
            for(int i : nextInt) {
                total += recur(s, i, cache);
            }
            cache.put(start, total);
            return total;
        }
    }
}
