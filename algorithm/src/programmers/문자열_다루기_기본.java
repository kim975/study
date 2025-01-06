package programmers;

/**
 * 문자열 다루기 기본
 * https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */
public class 문자열_다루기_기본 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("pPoooYy");
    }

    private static class Solution {
        public boolean solution(String s) {

            if (s.length() != 4 && s.length() != 6) {
                return false;
            }

            return s.matches("[0-9]*");
        }
    }
}
