package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 없는 숫자 더하기 : https://school.programmers.co.kr/learn/courses/30/lessons/86051
 */
public class 없는_숫자_더하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0});
    }

    private static class Solution {

        public int solution(int[] numbers) {

            int answer = 0;

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < 10; i++) {
                map.put(i, i);
            }

            for (int i = 0; i < numbers.length; i++) {
                map.put(numbers[i], 0);
            }

            for (Integer key : map.keySet()) {
                answer += map.get(key);
            }

            return answer;
        }
    }
}
