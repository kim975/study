package programmers;

/**
 * 이상한 문자 만들기
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
public class 이상한_문자_만들기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("  TRy HElLo  WORLD ");
    }

    private static class Solution {
        public String solution(String s) {
            StringBuilder sb = new StringBuilder();
            s = s.toLowerCase();

            int index = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != ' ') {
                    if (index % 2 == 0) {
                        sb.append((char) (s.charAt(i) + ('A' - 'a')));
                    } else {
                        sb.append(s.charAt(i));
                    }
                    index++;
                } else {
                    index = 0;
                    sb.append(s.charAt(i));
                }
            }

            return sb.toString().trim();
        }
    }
}
