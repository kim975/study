package programmers;

/**
 * 3진법 뒤집기
 * https://school.programmers.co.kr/learn/courses/30/lessons/68935
 */
public class _3진법_뒤집기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(45);
    }

    private static class Solution {
        public int solution(int n) {
            StringBuilder sb = new StringBuilder();
            int answer = 0;

            while (n > 0) {

                sb.append(n % 3);
                n /= 3;

            }

            String[] split = sb.reverse().toString().split("");
            for (int i = 0; i < split.length; i++) {
                answer += (int) (Math.pow(3, i) * Integer.parseInt(split[i]));
            }

            return answer;
        }
    }

}
