import java.util.*;

class Solution {
    static class Node {
        private String next;
        private int edge;

        public Node(String next, int edge) {
            this.next = next;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
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
