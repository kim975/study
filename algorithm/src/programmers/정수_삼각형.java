package programmers;

import java.util.Arrays;

/**
 * 정수 삼각형 : https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */
public class 정수_삼각형 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][]{
            {7},
            {3, 8},
            {8, 1, 0},
            {2, 7, 4, 4},
            {4, 5, 2, 6, 5}
        });
    }

    private static class Solution {

        int[][] mem = new int[501][501];

        public int solution(int[][] triangle) {

            for (int[] row : mem) {
                Arrays.fill(row, -1);
            }

            return sum(0, 0, triangle);
        }

        public int sum(int depth, int x, int[][] triangle) {

            if (mem[depth][x] != -1) {
                return mem[depth][x];
            }
            if (depth == triangle.length) {
                return 0;
            }

            return mem[depth][x] = triangle[depth][x] + Math.max(
                sum(depth + 1, x, triangle),
                sum(depth + 1, x + 1, triangle)
            );
        }
    }
}
