class Solution {
    Map<Integer, TreeSet<Integer>> componentS = new HashMap<>();

    private void dfs(int node, int vis[], Map<Integer, List<Integer>> adj, int Id, int componentId[]){
        vis[node] = 1;
        componentId[node] = Id;

        componentS.putIfAbsent(Id, new TreeSet<>());
        componentS.get(Id).add(node);
        for(int it: adj.getOrDefault(node, new ArrayList<>())){
            if(vis[it] == 0){
                dfs(it, vis, adj, Id, componentId);
            }
        }
    }
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for(int edge[]: connections){
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k->new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k->new ArrayList<>()).add(u);
        }


        int vis[] = new int[c+1];
        int componentId[] = new int[c+1];

        for(int node=1; node<=c; node++){
            if(vis[node] == 0){
                dfs(node, vis, adj, node, componentId);
            }
        }

        List<Integer> ansList = new ArrayList<>();

        for(int q[]: queries){
            int cond = q[0];
            int elem = q[1];

            int id = componentId[elem];
            TreeSet<Integer> set = componentS.get(id);

            if(cond == 1){
                if(set.contains(elem)){
                    ansList.add(elem);
                }else if(!set.isEmpty()){
                    ansList.add(set.first());
                }else{
                    ansList.add(-1);
                }
            }else{
                set.remove(elem);
            }
        }

        int ans[] = new int[ansList.size()];
        for(int i=0; i<ansList.size(); i++){
            ans[i] = ansList.get(i);
        }

        return ans;
    }
}
