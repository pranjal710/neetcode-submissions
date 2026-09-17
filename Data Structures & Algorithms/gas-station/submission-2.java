class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0, curr = 0, stationsVisited = 0, totalStation = gas.length;

        boolean isSolutionPossible = isSolutionPossible(gas, cost);
        if(isSolutionPossible) {
            int pendingGas = 0;
            while(stationsVisited < totalStation) {
                pendingGas = pendingGas + gas[curr] - cost[curr];
                curr = getNextIndex(curr, totalStation);
                stationsVisited++;
                while(pendingGas < 0 && stationsVisited < totalStation) {
                    start = getPrevIndex(start, totalStation);
                    pendingGas = pendingGas + gas[start] - cost[start];
                    stationsVisited++;
                }
            }
            return start;
        }
        return -1;
    }

    public boolean isSolutionPossible(int[] gas, int[] cost) {
        int sum = 0;
        for(int i = 0 ; i < gas.length; i++) {
            sum = sum + gas[i] - cost[i];
        }
        return sum >= 0;
    }

    public int getNextIndex(int i, int n) {
        return (i+1)%(n);
    }

    public int getPrevIndex(int i, int n) {
        return i-1 < 0 ? n - 1 : i-1;
    }
}
