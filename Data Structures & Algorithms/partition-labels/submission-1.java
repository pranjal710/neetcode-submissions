class Solution {
    private Map<Character, Integer> createLocationBasedMap (String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        return map;
    }

    public List<Integer> partitionLabels(String s) {
        List<Integer> substrings = new ArrayList<>();
        Map<Character, Integer> endLocation = createLocationBasedMap(s);
        int last = 0, start = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            last = Math.max(last, endLocation.get(ch));
            if(last == i) {
                substrings.add(last-start+1);
                start = last+1;
            }
        }
        return substrings;
    }
}
