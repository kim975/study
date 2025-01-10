package programmers;

/**
 * 모음사전
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class 모음사전 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("I");
    }

    private static class Solution {

        private final String[] alphabet = {"A", "E", "I", "O", "U"};
        private String word;
        private int count = 0;
        private boolean flag = false;
        public int solution(String word) {
            this.word = word;

            StringBuilder sb = new StringBuilder();
            findWord(sb);

            return count;
        }

        public void findWord(StringBuilder from) {

            if (from.toString().equals(word)){
                flag = true;
                return;
            }

            if (from.toString().length() == 5) {
                return;
            }

            for (String s : alphabet) {

                if (flag) {
                    return;
                }
                count++;
                findWord(from.append(s));
                from.delete(from.length() - 1, from.length());
            }
        }
    }
}
