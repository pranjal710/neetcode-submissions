class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> mapOfNumbers = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            if(!mapOfNumbers.containsKey(nums[i])) {
                mapOfNumbers.put(nums[i], new ArrayList<>());
            }
            mapOfNumbers.get(nums[i]).add(i);
        }
        for(int i = 0 ; i < nums.length; i++) {
            int diff = target - nums[i];
            if(diff != nums[i] && mapOfNumbers.containsKey(diff)) {
                return new int[]{i, mapOfNumbers.get(diff).get(0)};
            }
            if(diff == nums[i] && mapOfNumbers.get(diff).size() > 1) {
                return new int[]{mapOfNumbers.get(diff).get(0), mapOfNumbers.get(diff).get(1)};
            }
        }
        return null;
    }
}
