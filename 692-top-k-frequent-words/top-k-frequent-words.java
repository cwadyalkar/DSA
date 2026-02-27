class Solution {
    class Words implements Comparable<Words>{
        String word;
        int frequency;

        Words(String word,int frequency){
            this.word = word;
            this.frequency = frequency;
        }

       @Override
        public int compareTo(Words that) {
            if (this.frequency == that.frequency) {
                return this.word.compareTo(that.word);
            }
            return that.frequency - this.frequency;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> list = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Words> pq = new PriorityQueue<>();
        for(String str : words){
            map.put(str,map.getOrDefault(str,0)+1);
        }

        for(Map.Entry<String,Integer> entry : map.entrySet()){
           pq.add(new Words(entry.getKey(), entry.getValue()));
        }
        for(int i = 0;i < k;i++){
            Words mapwords = pq.poll();
            list.add(mapwords.word);
        }

        System.out.println(map);
        return list;
    }
}