package programmers;

/**
 * 문자열 내 p와 y의 개수
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */
public class 문자열_내_p와_y의_개수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("pPoooYy");
    }

    private static class Solution {
        boolean solution(String s) {
            boolean answer = true;
            int temp = s.length();
            s = s.toLowerCase();

            s = s.replaceAll("p", "");

            int pCount = temp - s.length();
            temp = s.length();
            s = s.replaceAll("y", "");
            int yCount = temp - s.length();

            return pCount == yCount;
        }
    }
}
