package programmers;

import java.util.Arrays;

/**
 * H-index : https://school.programmers.co.kr/learn/courses/30/lessons/42747
 */
public class H_index {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[] {3, 0, 6, 1, 5});
    }

    private static class Solution {
        public int solution(int[] citations) {
            Arrays.sort(citations);

            for (int i = citations.length; i > 0 ; i--) {
                if (citations[citations.length - i] >= i) {
                    return i;
                }
            }

            return 0;
        }
    }
}
