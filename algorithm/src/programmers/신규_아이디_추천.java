package programmers;

/**
 * 신규 아이디 추천
 * https://school.programmers.co.kr/learn/courses/30/lessons/72410
 */
public class 신규_아이디_추천 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("...!@BaT#*..y.abcdefghijklm");
    }

    private static class Solution {
        public String solution(String new_id) {
            new_id = new_id.toLowerCase();
            new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
            new_id = new_id.replaceAll("[.]{2,}", ".");
            new_id = new_id.startsWith(".") ? new_id.substring(1) : new_id;
            new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;
            new_id = new_id.isEmpty() ? "a" : new_id;
            new_id = new_id.length() >= 16 ? new_id.substring(0, 15) : new_id;
            new_id = new_id.endsWith(".") ? new_id.substring(0, new_id.length() - 1) : new_id;
            new_id = new_id.length() <= 2 ? new_id + String.valueOf(new_id.charAt(new_id.length() - 1)).repeat(3 - new_id.length()) : new_id;
            return new_id;
        }
    }

}
