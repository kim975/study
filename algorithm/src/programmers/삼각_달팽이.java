package programmers;

/**
 * 삼각_달팽이
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
public class 삼각_달팽이 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(4);
    }

    private static class Solution {

        public int[] solution(int n) {


            int index = n * (n + 1) / 2;

            Position position = new Position(n);

            for (int i = 1; i <= index; i++) {
                position.move(i);
            }

            int[] answer = new int[index];

            int[][] board = position.board;

            int answerIndex = 0;

            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < i + 1; j++) {
                    answer[answerIndex++] = board[i][j];
                }
            }

            return answer;
        }

        class Position {

            // y, x
            private int[][] movePosition = {{1, 0}, {0, 1}, {-1, -1}};
            private int currentMovePosition = 0;
            private int currentX = 0;
            private int currentY = -1;
            private int maxX;
            private int maxY;
            private int[][] board;

            public Position(int max) {
                this.maxX = max;
                this.maxY = max;
                this.board = new int[max][max];
            }

            public void move(int num) {
                if (isEdge() || isFill()) {
                    currentMovePosition = (currentMovePosition + 1) % 3;
                }

                currentY = currentY + movePosition[currentMovePosition][0];
                currentX = currentX + movePosition[currentMovePosition][1];

                board[currentY][currentX] = num;

            }

            public boolean isEdge() {
                return currentY + movePosition[currentMovePosition][0] >= maxY
                    || currentX + movePosition[currentMovePosition][1] >= maxX
                    || currentY + movePosition[currentMovePosition][0] < 0
                    || currentX + movePosition[currentMovePosition][1] < 0;
            }

            public boolean isFill() {
                return board[currentY + movePosition[currentMovePosition][0]][currentX + movePosition[currentMovePosition][1]] != 0;
            }

        }

    }

}


