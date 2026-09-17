class Solution {
    public boolean isHappy(int n) {
        int slow = n, fast = n;
        do {
            slow = getSumSq(slow);
            fast = getSumSq(fast);
            fast = getSumSq(fast);
        } while(slow != fast && fast != 1);
        return fast == 1;
        // Set<Integer> usedNumbers = new HashSet<>();
        // int number = n;
        // while(number != 1 && !usedNumbers.contains(number)) {
        //     System.out.println(number);
        //     number = getSumSq(number);
            
        // }
        // return number == 1;
    }

    public int getSumSq(int n) {
        int sum = 0, num = n;
        while(num > 0) {
            int digit = num%10;
            num = num/10;
            sum += digit*digit;
        }
        return sum;
    }
}
