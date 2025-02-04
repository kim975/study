package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 피보나치 수 : https://school.programmers.co.kr/learn/courses/30/lessons/12945
 */
public class 피보나치_수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5);
    }

    private static class Solution {
        public int solution(int n) {

            List<Integer> list = new ArrayList<>();

            list.add(0);
            list.add(1);

            for (int i = 2; i <= n; i++) {
                list.add((list.get(i - 1) + list.get(i - 2)) % 1234567);
            }

            return list.get(list.size() - 1);
        }
    }
}
