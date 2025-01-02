package programmers;

/**
 * 문자열 압축
 * https://school.programmers.co.kr/learn/courses/30/lessons/60057
 */
public class 문자열_압축 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("x");
    }

    private static class Solution {
        public int solution(String s) {
            int min = Integer.MAX_VALUE;

            if (s.length() == 1) {
                return 1;
            }

            for (int i = 1; i <= s.length() / 2; i++) {
                int zip = zip(i, s);
                min = Math.min(min, zip);
            }

            return min;
        }

        public int zip(int num, String str) {
            StringBuilder sb = new StringBuilder();
            String temp = str.substring(0, num);
            int count = 1;
            int over = 0;

            for (int i = num; i < str.length(); i = i + num) {

                if (i + num > str.length()) {
                    over = i;
                    break;
                }

                if (str.substring(i, i + num).equals(temp)) {
                    count++;
                } else {
                    sb.append(count == 1 ? "" : count).append(temp);

                    temp = str.substring(i, i + num);
                    count = 1;
                }
            }

            sb.append(count == 1 ? "" : count).append(temp);

            if (over > 0) {
                sb.append(str.substring(over));
            }

            System.out.println(sb + " : " + sb.length());
            return sb.toString().length();
        }

    }
}
