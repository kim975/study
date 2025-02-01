package programmers;

import java.util.Arrays;

/**
 * 징검다리 : https://school.programmers.co.kr/learn/courses/30/lessons/43236
 */
public class 징검다리 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(25, new int[] {2, 14, 11, 21, 17}, 2);
    }

    private static class Solution {

        private boolean isValid(int d, int[] rocks, int n) {

            int removed = 0;
            int currentRock = 0;
            for (int rock : rocks) {
                if (rock - currentRock < d) {
                    removed++;
                    continue;
                }

                currentRock = rock;
            }

            return removed <= n;
        }

        public int solution(int distance, int[] rocks, int n) {
            rocks = Arrays.copyOf(rocks, rocks.length + 1);
            rocks[rocks.length - 1] = distance;
            Arrays.sort(rocks);

            int start = 1;
            int end = distance + 1;

            while (end - start > 1) {
                int d = (start + end) / 2;

                if (isValid(d, rocks, n)) {
                    start = d;
                } else {
                    end = d;
                }
            }

            return start;
        }
    }
}
