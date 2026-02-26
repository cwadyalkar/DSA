class Solution {
    class CharFrequency implements Comparable<CharFrequency>{
        char ch;
        int frequency;

        CharFrequency(char ch,int frequency){
                this.ch = ch;
                this.frequency = frequency;
        }

        public int compareTo(CharFrequency that){
            return that.frequency - this.frequency;
        }
    
        public String toString() {
            return "(" + ch + ", " + frequency + ")";
        }

    }
    public String frequencySort(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        PriorityQueue<CharFrequency> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        // System.out.println("map--->"+map);

        
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            CharFrequency charFrequency = new CharFrequency(entry.getKey(),entry.getValue());
            
            pq.offer(charFrequency);
        }
        System.out.println("pq--->"+pq);

        

      while(!pq.isEmpty()){
            CharFrequency charFrequencies = pq.poll();
            char ch = charFrequencies.ch;
            int frequency = charFrequencies.frequency;
            System.out.println("ch--->"+ch);
            System.out.println("frequency--->"+frequency);

            for(int j = 0;j < frequency;j++){
                sb.append(ch);
            }

        }
        return sb.toString();
    }
}