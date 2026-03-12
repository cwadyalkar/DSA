class Solution {
    class Pair implements Comparable<Pair> {
        int ele;
        int frequency;

        Pair(int ele, int frequency) {
            this.ele = ele;
            this.frequency = frequency;
        }

        public int compareTo(Pair that){
           return that.frequency - this.frequency;
        }

    }

    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int result[] = new int[k];
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }

        for(int i = 0;i < k;i++){
            Pair pair = pq.poll();
            int ele = pair.ele;
            result[i] = ele;
        }
        

        return result;
    }
}