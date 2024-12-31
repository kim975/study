package programmers;

/**
 * 크기가 작은 부분 문자열
 * https://school.programmers.co.kr/learn/courses/30/lessons/147355
 */
public class 크기가_작은_부분_문자열 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("500220839878", "7");
    }

    private static class Solution {
        public int solution(String t, String p) {
            int answer = 0;

            long pInt = Long.parseLong(p);

            for (int i = 0; i <= t.length() - p.length(); i++) {
                if (Long.parseLong(t.substring(i, i + p.length())) <= pInt) {
                    answer++;
                }
            }

            return answer;
        }
    }

}
