package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 가장 큰 수 : https://school.programmers.co.kr/learn/courses/30/lessons/42746
 */
public class 가장_큰_수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{0,0,0});
    }

    private static class Solution {

        public String solution(int[] numbers) {

            String collect = Arrays.stream(numbers)
                .boxed()
                .map(String::valueOf)
                .sorted((i1, i2) -> {
                        String a = i1 + i2;
                        String b = i2 + i1;
                        return b.compareTo(a);
                    }
                )
                .collect(Collectors.joining());

            return collect.replaceAll("^0+", "0");
        }
    }
}
