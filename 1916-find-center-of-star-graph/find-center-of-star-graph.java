class Solution {
    public int findCenter(int[][] edges) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            map.put(u,map.getOrDefault(u,0)+1);
            map.put(v,map.getOrDefault(v,0)+1);

            if(map.get(u) == edges.length){
                return u;
            }
            if(map.get(v) == edges.length){
                return v;
            }

        }
        return -1;
    }
}