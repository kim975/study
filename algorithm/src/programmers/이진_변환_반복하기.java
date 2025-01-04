package programmers;

/**
 * 이진 변환 반복하기
 * https://school.programmers.co.kr/learn/courses/30/lessons/70129
 */
public class 이진_변환_반복하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("110010101001");
    }

    private static class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            while (!s.equals("1")) {

                int oriCount = s.length();

                s = s.replace("0", "");

                int replaceCount = s.length();

                answer[0]++;
                answer[1] += oriCount - replaceCount;

                s = Integer.toString(s.length(), 2);

            }

            return answer;
        }
    }

}
