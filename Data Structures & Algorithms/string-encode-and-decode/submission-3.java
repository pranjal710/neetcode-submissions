class Solution {

    static String DELIMITER = "\n";

    public String encode(List<String> strs) {
        return (strs.size() > 0 ? "1" : "0") + String.join(DELIMITER, strs);
    }

    public List<String> decode(String str) {
        System.out.println(str);
        if(str.charAt(0) == '0') {
            return Collections.emptyList();
        } else {
            return Arrays.asList(str.substring(1, str.length()).split(DELIMITER));
        }
    }
}
