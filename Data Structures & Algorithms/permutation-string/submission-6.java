class Solution {
    public Map<Character, Integer> getCount(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }
        return map;
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Count = getCount(s1);
        Map<Character, Integer> s2Count = getCount(s2);
        int left = 0, right = 0;
        System.out.println(s1Count);
        Map<Character, Integer> runningWindow = new HashMap<>();
        Set<Character> allKeys = new HashSet<>(s1Count.keySet());
        Set<Character> completedKeys = new HashSet<>();

        while(left <= right && right < s2.length()) {
            int rightCount = runningWindow.getOrDefault(s2.charAt(right), 0);
            runningWindow.put(s2.charAt(right), 1+rightCount);
            System.out.println("$ " + left + " " + right + " " + runningWindow);
            while(!completedKeys.equals(allKeys) && runningWindow.getOrDefault(s2.charAt(right), 0) > s1Count.getOrDefault(s2.charAt(right), 0)) {
                int leftCount = runningWindow.get(s2.charAt(left));
                leftCount--;
                if(leftCount == 0) {
                    runningWindow.remove(s2.charAt(left));
                    completedKeys.remove(s2.charAt(left));
                } else {
                    runningWindow.put(s2.charAt(left), leftCount);
                }
                left++;
                System.out.println("@ " + left + " " + right + " " + runningWindow);
            }
            if(s1Count.containsKey(s2.charAt(right)) && s1Count.get(s2.charAt(right)) == runningWindow.getOrDefault(s2.charAt(right), 0)) {
                completedKeys.add(s2.charAt(right));
            }
            right++;
            
            
        }
        
        
        return completedKeys.equals(allKeys);
    }
}
