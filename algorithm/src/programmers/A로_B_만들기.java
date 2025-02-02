package programmers;

import java.util.Arrays;

/**
 * A로 B 만들기 : https://school.programmers.co.kr/learn/courses/30/lessons/120886
 */
public class A로_B_만들기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("olleh", "hello");
    }

    private static class Solution {
        public int solution(String before, String after) {
            int answer = 0;

            char[] beforeArr = before.toCharArray();
            char[] afterArr = after.toCharArray();

            Arrays.sort(beforeArr);
            Arrays.sort(afterArr);

            return beforeArr.equals(afterArr) ? 1 : 0;
        }
    }
}
