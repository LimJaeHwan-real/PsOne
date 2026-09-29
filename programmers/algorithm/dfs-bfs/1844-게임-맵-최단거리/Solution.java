// 0-> 벽
// 1-> 길
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[][] maps) {
        int[][] dir={{1,0,-1,0},{0,1,0,-1}};
        Queue<int[]> q=new LinkedList<>();
        int answer = 0;

        int n=maps.length, m=maps[0].length;
        int[][] visited=new int[n][m];
        n-=1;
        m-=1;
        // 이부분 그냥 q.offer({0,0}) 넣었는데 new int[] 로 해줘야함
        q.offer(new int[]{0,0});
        visited[0][0]=1;
        while(!q.isEmpty())
        {
            int[] cur=q.poll();
            int X=cur[1], Y=cur[0];

            for(int i=0;i<4;i++)
            {
                int nx=X+dir[1][i],ny=Y+dir[0][i];
                if(nx<0||nx>m||ny<0||ny>n) continue;
                if(visited[ny][nx]>0||maps[ny][nx]==0) continue;

                q.offer(new int[]{ny,nx});
                visited[ny][nx]=visited[Y][X]+1;
            }
        }

        if(visited[n][m]==0)
            return -1;
        return visited[n][m];
    }
}
