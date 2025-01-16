package programmers;

import java.util.Arrays;

/**
 * K번째수 https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */
public class K번째수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
    }

    private static class Solution {

        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for (int i = 0; i < commands.length; i++) {
                int[] ints = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
                Arrays.sort(ints);
                answer[i] = ints[commands[i][2] - 1];
            }

            return answer;
        }
    }

}
