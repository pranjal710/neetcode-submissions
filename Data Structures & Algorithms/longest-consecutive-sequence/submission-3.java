class Solution {
    public int longestConsecutive(int[] nums) {
        // if()
        Map<Integer, Integer> startToCount = new HashMap<>();
        int max = 0;
        Set<Integer> numbers = new HashSet<>();
        for(int n : nums) numbers.add(n);
        for(int i = 0 ; i < nums.length; i++) {
            int start = nums[i];
            int curr = start;
            int count = 0;
            while(numbers.contains(curr) && !startToCount.containsKey(curr)) {
                count++;
                curr++;
            }
            startToCount.put(start, count + startToCount.getOrDefault(curr, 0));
            max = Math.max(max, startToCount.get(start));
        }
        return max;
    }
}
