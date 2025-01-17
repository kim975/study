package programmers;

import java.util.HashSet;
import java.util.Set;

/**
 * 두 개 뽑아서 더하기 : https://school.programmers.co.kr/learn/courses/30/lessons/68644
 */
public class 두_개_뽑아서_더하기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2, 1, 3, 4, 1});
    }

    private static class Solution {

        public int[] solution(int[] numbers) {

            Set<Integer> set = new HashSet<>();

            for (int i = 0; i < numbers.length; i++) {
                for (int j = i + 1; j < numbers.length; j++) {
                    set.add(numbers[i] + numbers[j]);
                }
            }
            return set.stream().sorted().mapToInt(i -> i).toArray();
        }
    }
}
