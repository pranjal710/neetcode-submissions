class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for(int stone : stones) {
            queue.add(stone);
        }
        int firstHeavy = -1;
        int secondHeavy = -1;
        while(queue.size() > 1) {
            if(firstHeavy == -1) {
                firstHeavy = queue.remove();
            } else if(secondHeavy == -1) {
                secondHeavy = queue.remove();
            }
            if(firstHeavy != -1 && secondHeavy != -1) {
                if(firstHeavy != secondHeavy) {
                    queue.add((firstHeavy - secondHeavy));
                }
                firstHeavy = -1;
                secondHeavy = -1;
            }
        }
        if(secondHeavy == -1 && firstHeavy != -1) {
            return firstHeavy - queue.remove();
        } else {
            return queue.remove();
        }
    }
}
// 2 2 3 4 6
// 6
// 4
// 2 2 2 3
// 3
// 2
//1 2 2
// 2
// 2
//1 <-