class Solution {
    class Number implements Comparable<Number> {
        int freq;
        int element;

        Number(int freq, int element) {
            this.freq = freq;
            this.element = element;
        }

        public int compareTo(Number that) {
            return that.freq - this.freq;

        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        // PriorityQueue (Min-Heap) to store top k frequent elements
        PriorityQueue<Number> pq = new PriorityQueue<>();

        // HashMap to store the frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        // Insert elements into the priority queue based on frequency

        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            Number number = new Number(entry.getValue(), entry.getKey());
            pq.offer(number);
        }
        // Array to store the result
        int res[] = new int[k];
        int index = 0;

        // Extract top k frequent elements from the priority queue

        while (index < k) {
            Number number = pq.poll();
            res[index] = number.element;
            index++;
        }
        return res;

        // i should revise once
    }
}