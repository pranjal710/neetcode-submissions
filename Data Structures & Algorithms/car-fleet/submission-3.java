class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Queue<double[]> q = new PriorityQueue<double[]>((a, b) -> Double.compare(a[0], b[0]));
        for(int i = 0 ; i < position.length; i++) {
            q.add(new double[]{position[i], (double)(target-position[i])/(double)speed[i]});
        }

        // Arrays.sort(timePair, (a, b) -> a[0] - b[0]);
// for(int[] x : timePair) System.out.println(x[0] + " " + x[1]);
        // return 0;

        Stack<double[]> s = new Stack<>();
        int fleet = 0;
        while(q.size() > 0) {
            double x[] = q.remove();
            System.out.println(x[0] + " " + x[1]);
            if(s.size() == 0) {
                s.push(x);
            } else if(s.peek()[1] <= x[1]) {
                while(s.size() > 0 && s.peek()[1] <= x[1]) {
                    s.pop();
                }
                s.push(x);
            } else {
                s.push(x);
            }
        }
        return s.size();

    }
}
