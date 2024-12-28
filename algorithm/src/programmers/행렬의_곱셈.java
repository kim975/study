package programmers;


/**
 * 행렬의 곱셈
 * https://school.programmers.co.kr/learn/courses/30/lessons/12949
 */
public class 행렬의_곱셈 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        solution.solution(new int[][]{{1,2,3}, {4,5,6}}, new int[][]{{1, 4}, {2, 4}, {3,6}});
    }

    private static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            for (int i = 0; i < answer.length; i++) {

                for (int j = 0; j < answer[i].length; j++) {

                    for (int k = 0; k < arr2.length; k++) {

                        int i1 = arr1[i][k];
                        int i2 = arr2[k][j];
                        answer[i][j] += i1 * i2;
                    }
                }
            }

            return answer;
        }
    }
}

/**
 * 1 2 3  1 4
 * 4 5 6  2 4
 *        3 6
 */
