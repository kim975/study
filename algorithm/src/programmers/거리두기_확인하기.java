package programmers;

import java.util.Arrays;

/**
 * 거리두기 확인하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/81302
 */
public class 거리두기_확인하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        solution.solution(new String[][]{{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
        solution.solution(new String[][]{{"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }

    private static class Solution {

        //0 1 2 3
        //상 좌 우 하
        public static final int[] dy = {-1, 0, 0, 1};
        public static final int[] dx = {0, -1, 1, 0};

        public int[] solution(String[][] places) {
            int[] answer = new int[places.length];

            Arrays.fill(answer, 1);

            for (int a = 0; a < answer.length; a++) {

                char[][] place = makePlace(places[a]);

                int checkResult = 1;

                asd:
                for (int i = 0; i < place.length; i++) {
                    for (int j = 0; j < place[i].length; j++) {
                        checkResult = checkSpace(place, i, j);
                        if (checkResult == 0) {
                            break asd;
                        }
                    }
                }

                answer[a] = checkResult;
            }

            return answer;
        }

        public char[][] makePlace(String[] oriPlace) {

            char[][] place = new char[5][5];

            for (int i = 0; i < oriPlace.length; i++) {
                place[i] = oriPlace[i].toCharArray();
            }

            return place;
        }

        public int checkSpace(char[][] place, int currentY, int currentX) {

            int result = 1;

            if (place[currentY][currentX] != 'P') {
                return 1;
            }

            for (int i = 0; i < 4; i++) {

                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny < 0 || ny >= place.length || nx < 0 || nx >= place[0].length) {
                    continue;
                }

                if (place[ny][nx] == 'P') {
                    return 0;
                }

                if (place[ny][nx] == 'O') {
                    if (checkSpace(place, ny, nx, i - 3) == 0) {
                        return 0;
                    }
                }
            }

            return result;
        }

        public int checkSpace(char[][] place, int currentY, int currentX, int excludeXY) {

            int result = 1;

            for (int i = 0; i < 4; i++) {

                if (Math.abs(excludeXY) == i) {
                    continue;
                }

                int ny = currentY + dy[i];
                int nx = currentX + dx[i];

                if (ny < 0 || ny >= place.length || nx < 0 || nx >= place[0].length) {
                    continue;
                }

                if (place[ny][nx] == 'P') {
                    return 0;
                }

            }

            return result;
        }

    }

}
