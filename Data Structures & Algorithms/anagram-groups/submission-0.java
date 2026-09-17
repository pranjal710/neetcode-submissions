class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> wordGroup = new HashMap<>();
        for(String s : strs) {
            String sortedChar = getSorrtedChar(s);
            if(!wordGroup.containsKey(sortedChar)) {
                wordGroup.put(sortedChar, new ArrayList<>());
            }
            wordGroup.get(sortedChar).add(s);
        }
        List<List<String>> response = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : wordGroup.entrySet()) {
            response.add(entry.getValue());
        }
        return response;
    }

    private String getSorrtedChar(String s) {
        char[] input = s.toCharArray();
        Arrays.sort(input);
        return new String(input);
    }
}