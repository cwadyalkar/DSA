class Solution {
    class Pair implements Comparable<Pair> {
        int freq;
        int executionTime;

        Pair(int freq, int executionTime) {
            this.freq = freq;
            this.executionTime = executionTime;
        }

        public int compareTo(Pair that) {
            return that.freq - this.freq;
        }

    }

    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        Queue<Pair> queue = new LinkedList<>();
        int time = 0;

        for (char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : map.keySet()) {
            int freq = map.get(ch);
            pq.offer(new Pair(freq, 0));
        }

        while(!pq.isEmpty() || !queue.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Pair pair = pq.poll();
                pair.freq--;
                if(pair.freq > 0){
                    pair.executionTime = time + n;
                    queue.offer(pair);
                }
            }

            if(!queue.isEmpty() && queue.peek().executionTime == time){
                pq.offer(queue.poll());
            }
        }
        return time;
    }
}