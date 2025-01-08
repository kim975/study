package programmers;

/**
 * 쿼드압축 후 개수 세기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class 쿼드압축_후_개수_세기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[][] {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}});
    }

    private static class Solution {

        int[] count = new int[2];


        public int[] solution(int[][] arr) {
            count(0, 0, arr.length, arr);
            return count;
        }

        public void count(int x, int y, int size, int[][] arr) {
            if (size < 2) {
                count[arr[y][x]]++;
                return;
            }

            int temp = arr[y][x];
            boolean same = true;

            for (int i = y; i < y + size; i++) {
                for (int j = x; j < x + size; j++) {
                    if (arr[i][j] != temp) {
                        same = false;
                    }
                }
            }

            if (same) {
                count[temp]++;
            } else {

                size = size / 2;

                count(x, y, size, arr);
                count(x + size, y, size, arr);
                count(x, y + size, size, arr);
                count(x + size, y + size, size, arr);
            }
        }

    }
}
