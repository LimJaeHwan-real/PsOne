import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[][] rectangle, int cx, int cy, int ix, int iy) {
        int answer = 0;
        int[][] dir = {{1, 0, -1, 0}, {0, 1, 0, -1}};

        // 좌표를 2배로 늘려 인접한 테두리 사이의 잘못된 이동을 막는다.
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < 4; j++) {
                rectangle[i][j] *= 2;
            }
        }
        cx *= 2;
        cy *= 2;
        ix *= 2;
        iy *= 2;

        int[][] visited = new int[102][102];
        int[][] map = new int[102][102];

        // 모든 직사각형의 테두리와 내부를 먼저 채운다.
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        // 직사각형 내부를 모두 지워 이동 가능한 테두리만 남긴다.
        for (int i = 0; i < rectangle.length; i++) {
            int x1 = rectangle[i][0];
            int y1 = rectangle[i][1];
            int x2 = rectangle[i][2];
            int y2 = rectangle[i][3];

            for (int j = y1 + 1; j < y2; j++) {
                for (int k = x1 + 1; k < x2; k++) {
                    map[j][k] = 0;
                }
            }
        }

        // BFS로 테두리를 따라 이동하는 최단 거리를 구한다.
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{cy, cx});
        visited[cy][cx] = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = cur[0] + dir[0][i];
                int nx = cur[1] + dir[1][i];
                if (1 <= ny && ny <= 100 && 1 <= nx && nx <= 100
                        && visited[ny][nx] == 0 && map[ny][nx] == 1) {
                    visited[ny][nx] = visited[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{ny, nx});
                }
            }
        }

        // 시작점의 방문 값 1을 빼고, 확대된 거리를 원래 단위로 돌린다.
        return (visited[iy][ix] - 1) / 2;
    }
}
