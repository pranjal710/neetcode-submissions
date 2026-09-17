class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //nums = new int[]{-1,0,1,2,-1,-4};
        System.out.println(Arrays.toString(nums));
        Set<List<Integer>> listFinal = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        getTriplets(nums, 3, 0, 0, list, listFinal);
        return new ArrayList<>(listFinal);
    }

    public void getTriplets(int[] nums, int level, int start, 
    int sumSoFar, List<Integer> list, Set<List<Integer>> listFinal) {
        if(level == 0) {
            if(sumSoFar == 0) {
                Collections.sort(list);
                listFinal.add(new ArrayList<>(list));
            }
            return;
        }

        for(int i = start ; i < nums.length; i++) {
            list.add(nums[i]);
            sumSoFar += nums[i];
            System.out.println(sumSoFar + " " + level + " " + nums[i] + " " + list.size());
            getTriplets(nums, level-1, i + 1, sumSoFar, list, listFinal);
            list.remove(3-level);
            sumSoFar -= nums[i];
        }
        return;
    }
}
