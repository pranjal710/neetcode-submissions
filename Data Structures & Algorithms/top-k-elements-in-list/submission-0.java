class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> input = new HashMap<>();
        for(int x : nums) {
            if(!input.containsKey(x)) {
                input.put(x, 0);
            }
            input.put(x, input.get(x) + 1);
        }
        List<int[]> valus = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : input.entrySet()) {
            valus.add(new int[]{entry.getKey(), entry.getValue()});
        }
        Collections.sort(valus, (a, b) -> b[1] - a[1]);
        int[] result = new int[k];
        for(int i = 0 ; i < k ; i++) {
            result[i] = valus.get(i)[0];
        }
        return result;
    }
}
