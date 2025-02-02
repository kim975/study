package programmers;

import java.util.Arrays;

/**
 * 전화번호 목록 : https://school.programmers.co.kr/learn/courses/30/lessons/42577
 */
public class 전화번호_목록 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[] {"123456789"});
    }

    private static class Solution {
        public boolean solution(String[] phone_book) {

            Arrays.sort(phone_book);

            for (int i = 0; i < phone_book.length - 1; i++) {
                if (phone_book[i + 1].startsWith(phone_book[i])) {
                    return false;
                }
            }

            return true;
        }
    }

}
