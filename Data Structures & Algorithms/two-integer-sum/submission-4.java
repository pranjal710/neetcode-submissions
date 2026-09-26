class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        // Map<Integer, Integer> countMap = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            map.put(nums[i], i);
            // countMap.put(nums[i], countMap.getOrDefault(nums[i], 0)+1);
        }

        // System.out.println(map);
        // System.out.println(countMap);

        for(int i = 0 ; i < nums.length; i++) {
            if(map.containsKey(target-nums[i]) && ((map.get(target-nums[i]) != i))) {
                return new int[]{i, map.get(target-nums[i])};
            }
        }
        return null;
    }
}
