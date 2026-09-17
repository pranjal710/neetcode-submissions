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
        boolean keycount = false;
        while(left <= right && right < s2.length()) {
            int rightCount = runningWindow.getOrDefault(s2.charAt(right), 0);
            runningWindow.put(s2.charAt(right), 1+rightCount);
            System.out.println("$ " + left + " " + right + " " + runningWindow);
            while(runningWindow.getOrDefault(s2.charAt(right), 0) > s1Count.getOrDefault(s2.charAt(right), 0)) {
                int leftCount = runningWindow.get(s2.charAt(left));
                leftCount--;
                if(leftCount == 0) {
                    runningWindow.remove(s2.charAt(left));
                } else {
                    runningWindow.put(s2.charAt(left), leftCount);
                }
                left++;
                System.out.println("@ " + left + " " + right + " " + runningWindow);
            } 
            keycount = keycount && (runningWindow.getOrDefault(s2.charAt(right), 0) == s1Count.getOrDefault(s2.charAt(right), 0));
            right++;
            if (s1Count.size() == runningWindow.size()) {
                boolean shouldContinue = false;
                for(Map.Entry<Character, Integer> e : s1Count.entrySet()) {
                    if(e.getValue() != runningWindow.get(e.getKey())) {
                        shouldContinue = true;
                        continue;
                    }
                }
                if(!shouldContinue) {
                    return true;
                }
            }
            
        }
        
        
        return false;
    }
}
