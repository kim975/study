package programmers;

import java.util.Arrays;

/**
 * 문자열 내림차순으로 배치하기 : https://school.programmers.co.kr/learn/courses/30/lessons/12917
 */
public class 문자열_내림차순으로_배치하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("Zbcdefg");
    }

    private static class Solution {
        public String solution(String s) {

            char[] split = s.toCharArray();
            Arrays.sort(split);
            return new StringBuilder(String.valueOf(split)).reverse().toString();
        }
    }
}
