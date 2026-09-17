class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] chars = new int[26];
        updateArrayWithLastChar(chars, s);
        System.out.println(chars);
        int left = 0, right = 0;
        List<Integer> result = new ArrayList<>();
        while(right < s.length()) {
            right = getMaxright(s, chars, left);
            result.add(right - left + 1);
            right = right + 1;
            left = right;
        }
        return result;
    }

    private int getMaxright(String s, int[] chars, int left) {
        int r = chars[s.charAt(left) - 'a'], l = left;
        while(r < s.length() && l < r) {
            r = Math.max(r, chars[s.charAt(l) - 'a']);
            System.out.println(r + " " + s.charAt(l));
            l++;
        }
        System.out.println("##");
        return r;
    }

    private void updateArrayWithLastChar(int[] chars, String s) {
        int index = 0;
        for(char ch : s.toCharArray()) {
            chars[ch - 'a'] = index++;
        }
        for(int i = 0 ; i < chars.length;i++) {
            System.out.print(chars[i] + " ");
        }
        System.out.println("");
    }
}
