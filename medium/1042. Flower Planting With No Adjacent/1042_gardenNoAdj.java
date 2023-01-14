class Solution {
    
    ArrayList<ArrayList<Integer> > graph;
    
    public int[] gardenNoAdj(int n, int[][] paths) {
        
         graph = new ArrayList(n);
        
        for(int i  = 0;i<n;i++)
            graph.add(new ArrayList(3));
        
        for(int t[] : paths) {
            graph.get(t[0]-1).add(t[1]-1);
            graph.get(t[1]-1).add(t[0]-1);
        }
        
        int ans[] = new int[n];
        
        for(int i = 0;i<n;i++){
            if( ans[i] == 0 )
                assign(ans, i);
        }
        
        return ans;
    }
    
    void assign(int ans[], int src) {
        Queue<Integer> q = new LinkedList();
        
        q.add(src);
        ans[src] = 1;
        
        while(!q.isEmpty()){
            int u = q.poll();
            int color = ans[u];
            
            for(int v : graph.get(u)){
                if( ans[v] == 0 || ans[v] == color ) {
                    ans[v] = color == 4 ? 1 : color +1;
                    q.add(v);
                }    
            }            
        }        
    }   
}