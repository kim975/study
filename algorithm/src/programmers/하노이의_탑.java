package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 하노이의 탑
 * https://school.programmers.co.kr/learn/courses/30/lessons/12946
 */
public class 하노이의_탑 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(3);
    }

    private static class Solution {
        public int[][] solution(int n) {

            List<int[]> result = new ArrayList<>();

            hanoi(n, 1, 3, result);
            return result.toArray(new int[0][]);
        }

        private void hanoi(int n, int from, int to, List<int[]> result) {

            if(n == 1) {
                result.add(new int[]{from, to});
                return;
            }

            int empty = 6 - from - to;
            hanoi(n - 1, from, empty, result);
            hanoi(1, from, to, result);
            hanoi(n - 1, empty, to,result);
        }
    }
}
