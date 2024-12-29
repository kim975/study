package programmers;

/**
 * 자연수 뒤집어 배열로 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12932
 */
public class 자연수_뒤집어_배열로_만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(12345);
    }

    private static class Solution {
        public int[] solution(long n) {
            char[] charArray = new StringBuilder(String.valueOf(n)).reverse().toString().toCharArray();

            int[] answer = new int[charArray.length];

            for (int i = 0; i < charArray.length; i++) {
                answer[i] = charArray[i] - '0';
            }

            return answer;
        }
    }
}
