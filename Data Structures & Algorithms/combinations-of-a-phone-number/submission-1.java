class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length() == 0) {
            return result;
        } else {
            int[] nums = new int[digits.length()];
            int index = digits.length() - 1;
            int number = Integer.parseInt(digits);
            while(number > 0) {
                nums[index--] = number%10;
                number = number/10;
            }
            dfs(nums, 0, new ArrayList<>(), result);
            return result;
        }
    }

    public String joinString(List<String> in) {
        StringBuilder str = new StringBuilder();
        for(String s : in) {
            str.append(s);
        }
        return str.toString();
    }

    public void dfs(int[] digits, int index, List<String> temp, List<String> result) {
        if(index == digits.length) {
            result.add(joinString(temp));
        } else {
            int digit = digits[index];
            List<String> children = getChars(digit);
            for(String ch : children) {
                temp.add(ch);
                dfs(digits, index+1, temp, result);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public List<String> getChars(int num) {
        switch (num) {
            case 2: return Arrays.asList(new String[]{"a", "b", "c"});
            case 3: return Arrays.asList(new String[]{"d", "e", "f"});
            case 4: return Arrays.asList(new String[]{"g", "h", "i"});
            case 5: return Arrays.asList(new String[]{"j", "k", "l"});
            case 6: return Arrays.asList(new String[]{"m", "n", "o"});
            case 7: return Arrays.asList(new String[]{"p", "q", "r", "s"});
            case 8: return Arrays.asList(new String[]{"t", "u", "v"});
            case 9: return Arrays.asList(new String[]{"w", "x", "y", "z"});
            default: return Collections.emptyList();
        }
    }
}
