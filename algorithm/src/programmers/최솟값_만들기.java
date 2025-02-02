package programmers;

import java.util.Arrays;

/**
 * 최솟값 만들기 : https://school.programmers.co.kr/learn/courses/30/lessons/12941
 */
public class 최솟값_만들기 {

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.solution(45);
    }

    private static class Solution {
        public int solution(int[] A, int[] B) {
            int answer = 0;

            Arrays.sort(A);
            Arrays.sort(B);

            for (int i = 0; i < A.length; i++) {
                answer += A[i] * B[B.length - 1 - i];
            }

            return answer;
        }
    }
}
