package programmers;

/**
 * 중복된 문자 제거 : https://school.programmers.co.kr/learn/courses/30/lessons/120888
 */
public class 중복된_문자_제거 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("people");
    }

    private static class Solution {
        public String solution(String my_string) {
            String answer = "";

            for (int i = 0; i < my_string.length(); i++) {
                char c = my_string.charAt(i);
                if (!answer.contains(String.valueOf(c))) {
                    answer += String.valueOf(c);
                }
            }

            return answer;
        }
    }

}
