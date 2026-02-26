class Solution {
    class Number implements Comparable<Number>{
        int element;
        int frequency;

        Number(int element,int frequency){
            this.frequency = frequency;
            this.element = element;
        }

        public int compareTo(Number that){
            return that.frequency - this.frequency;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> queue = new PriorityQueue<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans[] = new int[k];
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            Number number = new Number(entry.getKey(),entry.getValue());
            queue.offer(number);
        }

        for(int i = 0;i < k;i++){
            Number number = queue.poll();
            ans[i] = number.element;
        }
      
        return ans;
    }
}