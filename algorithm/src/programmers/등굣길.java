package programmers;

import java.util.Arrays;

/**
 * 등굣길 : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */
public class 등굣길 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, 5, new int[][]
            {

            }
        );
    }

    private static class Solution {

        int[][] mem = null;

        public int solution(int m, int n, int[][] puddles) {

            mem = new int[n][m];

            for (int[] row : mem) {
                Arrays.fill(row, -1);
            }

            mem[n - 1][m - 1] = Integer.MIN_VALUE;

            for (int i = 0; i < puddles.length; i++) {

                int x = puddles[i][0] - 1;
                int y = puddles[i][1] - 1;

                mem[y][x] = -2;

            }

            int i = find(0, 0);
            return i;
        }

        public int find(int y, int x) {

            if (y >= mem.length || x >= mem[y].length) {
                return 0;
            }

            if (mem[y][x] == -2) {
                return 0;
            }

            if (mem[y][x] == Integer.MIN_VALUE) {
                return 1;
            }

            if (mem[y][x] != -1 && mem[y][x] != -2 && mem[y][x] != Integer.MIN_VALUE) {
                return mem[y][x];
            }

            return mem[y][x] = (find(y, x + 1) + find(y + 1, x)) % 1000000007;
        }
    }
}
