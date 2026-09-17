class Solution {
    static class TaskMetaData{
        private char task;
        private int occurance;

        public TaskMetaData(char task) {
            this.task = task;
        }

        public void incrementOccurance() {
            this.occurance++;
        }

        public void decrementOccurance() {
            this.occurance--;
        }

        public int getOccurance() {
            return this.occurance;
        }

        public char getTask() {
            return this.task;
        }

    }

    static class TaskOccurance {
        private final TaskMetaData metadata;
        private final int nextOccurance;

        public TaskOccurance(TaskMetaData metadata, int nextOccurance) {
            this.metadata = metadata;
            this.nextOccurance = nextOccurance;
        }

        public TaskMetaData getTaskMetadata() {
            return this.metadata;
        }

        public boolean isRightTime(int time) {
            return time == nextOccurance;
        }

        public int getNextOccurance() {
            return nextOccurance;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        Map<Character, TaskMetaData> metaDataMap = new HashMap<>();
        PriorityQueue<TaskMetaData> metaDataQ = new PriorityQueue<>((a,b) -> b.getOccurance() - a.getOccurance());
        PriorityQueue<TaskOccurance> occuranceQ = new PriorityQueue<>((a,b) -> a.getNextOccurance() - b.getNextOccurance());
        for(char t : tasks) {
            TaskMetaData metaData = metaDataMap.getOrDefault(t, new TaskMetaData(t));
            metaData.incrementOccurance();
            metaDataMap.put(t, metaData);
        }
        for(TaskMetaData t: metaDataMap.values()) {
            metaDataQ.add(t);
        }
        int currTime = 0;
        
        while(metaDataQ.size() > 0 || occuranceQ.size() > 0) {
            char currChar = '1';
            if(occuranceQ.size() > 0 && occuranceQ.peek().isRightTime(currTime)) {
                metaDataQ.add(occuranceQ.remove().getTaskMetadata());
            }
            if(metaDataQ.size() > 0) {
                TaskMetaData currMetaData = metaDataQ.remove();
                currMetaData.decrementOccurance();
                currChar = currMetaData.getTask();
                System.out.println(currChar);
                if(currMetaData.getOccurance() > 0) {
                    occuranceQ.add(new TaskOccurance(currMetaData, currTime+n+1));
                }
            }
            currTime++;
        }
        return currTime;
    }
}
