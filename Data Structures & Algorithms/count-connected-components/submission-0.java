class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> links = new HashMap<>();
        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0 ; i < n; i++){
            links.put(i,new HashSet<Integer>());
        }
        for(int[] i : edges){
            links.get(i[0]).add(i[1]);
            links.get(i[1]).add(i[0]);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++){
            if(visited.contains(i)) continue;
            ans++;
            dfs(links,visited,i);
        }
        return ans;
    }
    void dfs(HashMap<Integer,HashSet<Integer>> links, HashSet<Integer> visited, int node){
        if(visited.contains(node))  return;
        visited.add(node);
        for(int i : links.get(node)){
            dfs(links,visited,i);
        }
        return;
    }
}
