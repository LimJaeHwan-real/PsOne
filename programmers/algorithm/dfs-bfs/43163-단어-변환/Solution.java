/*
현재 단어에서 한 글자만 달라진 경우 다시 DFS 호출
*/
import java.util.*;

class Solution {
    public int answer = Integer.MAX_VALUE;
    public int[] visited;

    static class Node {
        private String next;
        private int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public boolean diff(String s1, String s2) {
        int num = s1.length();
        int cnt = 0;

        for (int i = 0; i < num; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }

        if (cnt == 1)
            return true;
        return false;
    }

    public boolean count_target(String target, String[] words) {
        int cnt = 0;

        for (String w : words) {
            // 문자열 비교시 equals() 로 비교
            if (w.equals(target)) {
                cnt++;
            }
        }

        if (cnt == 0)
            return false;

        return true;
    }

    public void dfs(String cur, String target, String[] words, int step) {
        if (cur.equals(target)) {
            answer = Math.min(answer, step);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (diff(cur, words[i]) && visited[i] != 1) {
                visited[i] = 1;
                dfs(words[i], target, words, step + 1);
                visited[i] = 0;
            }
        }
    }

    public int solution(String begin, String target, String[] words) {
        // words에 target이 존재하지 않음
        if (!count_target(target, words)) {
            return 0;
        }

        visited = new int[words.length];

        dfs(begin, target, words, 0);

        // 답이 없을 경우 처리해야 함
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public int bfs(String begin, String target, String[] words) {
        int answer = 0;
        int n = words.length;

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));

        boolean[] visited = new boolean[n];
        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (cur.next.equals(target)) {
                answer = cur.edge;
                break;
            }

            for (int i = 0; i < n; i++) {
                if (!visited[i] && isNext(cur.next, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], cur.edge + 1));
                }
            }
        }

        return answer;
    }

    public static boolean isNext(String cur, String comp) {
        // 오직 하나의 글자만 다를 경우 true
        int cnt = 0;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != comp.charAt(i)) {
                cnt++;
                if (cnt > 1)
                    return false;
            }
        }

        return cnt == 1;
    }
}
