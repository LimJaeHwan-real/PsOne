class Solution {
    // 그래프 노드마다 dfs 호출한다.
    // 방문할때마다 방문체크
    
    public void dfs(int start, int[] visited, int[][] computers){
        if(visited[start]==1)
            return;
        
        visited[start]=1;
        for(int i=0;i<computers.length;i++){
            if(computers[start][i]==1)
            {
                dfs(i,visited,computers);
            }
        }
        
    }
    
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[] visited=new int[n];
        for(int i=0;i<n;i++){
            if(visited[i]==0)
            {
                answer++;
                dfs(i,visited,computers);
            }
        }
        return answer;
    }
    
    
    
}