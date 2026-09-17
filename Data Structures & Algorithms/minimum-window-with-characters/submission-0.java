class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> subStringCountMap = getCountMap(t);
        System.out.println(subStringCountMap);
        Map<Character, Integer> runningCount = new HashMap<>();
        int left = 0, right = 0;
        Set<Character> charactersToFind = new HashSet<>(subStringCountMap.keySet());
        Set<Character> charactersCompleted = new HashSet<>();
        String result = "";
        while(right < s.length()) {
            System.out.println("! "+ left + " " + right );
            char rightChar = s.charAt(right);
            runningCount.put(rightChar, runningCount.getOrDefault(rightChar, 0) + 1);
            System.out.println(runningCount);
            if(charactersToFind.contains(rightChar) && runningCount.get(rightChar)  == subStringCountMap.get(rightChar)) {
                charactersCompleted.add(rightChar);
                if(charactersCompleted.equals(charactersToFind)) {
                    while(!charactersToFind.contains(s.charAt(left)) || 
                    (charactersToFind.contains(s.charAt(left)) && runningCount.get(s.charAt(left)) > subStringCountMap.get(s.charAt(left)) )) {
                        runningCount.put(s.charAt(left), runningCount.get(s.charAt(left))-1);
                        if(runningCount.get(s.charAt(left)) == 0) {
                            runningCount.remove(s.charAt(left));
                        }
                        left++;
                        System.out.println("@ "+ left + " " + right );
                    }
                    if("".equals(result) || result.length() > right-left+1){
                        result = s.substring(left, right+1);
                    }
                    runningCount.put(s.charAt(left), runningCount.get(s.charAt(left))-1);
                    if(runningCount.get(s.charAt(left)) == 0) {
                        runningCount.remove(s.charAt(left));
                    }
                    charactersCompleted.remove(s.charAt(left));
                    left++;
                }
            }
            right++;
        }
        return result;


    }

    private Map<Character, Integer> getCountMap(String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : t.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            map.put(ch, count+1);
        }
        return map;
    }
}
