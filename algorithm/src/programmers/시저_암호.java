package programmers;

public class 시저_암호 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("z a", 1);
    }

    private static class Solution {
        public String solution(String s, int n) {
            String answer = "";

            for (char c : s.toCharArray()) {

                if (c == ' ') {
                    answer += c;
                    continue;
                }

                boolean upper = c >= 'A' && c <= 'Z';
                int alpha = (upper ? c - 'A' + n: c - 'a' + n) % 26;
                char temp = (char) (upper ? 'A' + alpha : 'a' + alpha);

                answer += String.valueOf(temp);
            }

            return answer;
        }
    }
}
