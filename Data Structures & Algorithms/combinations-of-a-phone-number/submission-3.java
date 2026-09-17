class Solution {
    private Map<Integer, String> getMap() {
        Map<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");
        return map;
    }

    public List<String> letterCombinations(String digits) {
        Map<Integer, String> mappings = getMap();
        Map<Integer, List<String>> cache = new HashMap<>();
        return backtrack(mappings, digits, 0, cache);
    }

    private List<String> backtrack(Map<Integer, String> mappings, String digits, int currIndex, Map<Integer, List<String>> cache) {
        List<String> resp = new ArrayList<>();
        if(digits.length() == 0)  return resp;
        if(currIndex == digits.length()) {
            resp.add("");
            return resp;
        } else if(cache.containsKey(currIndex)) {
            return cache.get(currIndex);
        } else {
            int curr = digits.charAt(currIndex) - '0';
            for(char ch : mappings.get(curr).toCharArray()) {
                resp.addAll(backtrack(mappings, digits, currIndex+1, cache).stream().map(c -> ch + c).collect(Collectors.toList()));
            }
            cache.put(currIndex, resp);
            return resp;
        }
    }
}
