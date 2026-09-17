class Solution {
    private Map<Character, Integer> getFrequency(String s) {
        char[] input = s.toCharArray();
        Map<Character, Integer> res = new HashMap<>();
        for(char ch : input) {
            res.put(ch, res.getOrDefault(ch, 0) + 1);
        }
        return res;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> frequency = getFrequency(s1);
        int l = 0, r = 0;
        while(r < s2.length() && frequency.size() != 0) {
            char ch = s2.charAt(r++);
            frequency.put(ch, frequency.getOrDefault(ch, 0)-1);
            while(frequency.get(ch) < 0) {
                char lch = s2.charAt(l++);
                frequency.put(lch, frequency.getOrDefault(lch, 0)+1);
            }
            if(frequency.get(ch) == 0) {
                frequency.remove(ch);
            }
        }
        return frequency.size() == 0;
    }
}
