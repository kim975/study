package programmers;

import java.util.Arrays;

/**
 * 문자열 내 마음대로 정렬하기 : https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[] {"sun", "bed", "car"}, 1);
    }

    private static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, (s1, s2) -> {
                if (s1.charAt(n) == s2.charAt(n)) {
                    return s1.compareTo(s2);
                }
                return s1.charAt(n) - s2.charAt(n);
            });

            return strings;
        }
    }
}
