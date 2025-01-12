package programmers;

/**
 * 카펫
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class 카펫 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(24, 24);
    }

    private static class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            asd:
            for (int width = 3; width < 5000; width++) {
                for (int height = 3; height <= width; height++) {

                    int yellowCount = (width - 2) * (height - 2);

                    if (yellowCount == yellow) {
                        if (width * height - yellowCount == brown) {
                            answer[0] = width;
                            answer[1] = height;
                            break asd;
                        }
                    }
                }
            }



            return answer;
        }
    }
}
