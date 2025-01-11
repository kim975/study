package programmers;

import java.util.stream.IntStream;

/**
 * 모의고사
 * https://school.programmers.co.kr/learn/courses/30/lessons/42840
 */
public class 모의고사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 4, 5});
    }

    private static class Solution {

        int[][] person = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        public int[] solution(int[] answers) {
            int[] answer = new int[3];
            int max = Integer.MIN_VALUE;

            for (int i = 0; i < person.length; i++) {
                answer[i] = check(i, answers);
                max = Math.max(max, answer[i]);
            }

            int finalMax = max;
            return IntStream.range(0, 3)
                .filter(i -> answer[i] == finalMax)
                .map(i -> i + 1)
                .toArray();
        }

        public int check(int personIndex, int[] answers) {
            int result = 0;
            int[] personAnswer = person[personIndex];

            for (int i = 0; i < answers.length; i++) {
                if (personAnswer[i % personAnswer.length] == answers[i]) {
                    result++;
                }
            }
            return result;
        }
    }
}
