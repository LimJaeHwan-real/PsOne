/*
현재 단어에서 한 글자만 달라진 경우 다시 DFS 호출
*/
import java.util.*;

class Solution {
    public int answer = Integer.MAX_VALUE;
    public int[] visited;

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
}
