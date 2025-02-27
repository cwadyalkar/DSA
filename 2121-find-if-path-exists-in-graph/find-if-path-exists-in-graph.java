class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adjList.add(new ArrayList<>());
        }


        for(int i = 0; i <edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);

        }

        boolean visited[] = new boolean[n];
        boolean found = dfs(adjList,source,destination,visited);
        return found;


    }

    public boolean dfs(ArrayList<ArrayList<Integer>> adjList,int curr,int dest,boolean visited[]){
        visited[curr] = true;
        if(curr == dest ) return true;

        for(int neighbour : adjList.get(curr)){
            if(!visited[neighbour]){
                boolean found = dfs(adjList,neighbour,dest,visited);
                if(found){
                    return true;
                }
            }
        }
        return false;
    }
}