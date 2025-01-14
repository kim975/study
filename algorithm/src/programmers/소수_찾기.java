package programmers;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 소수 찾기
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */
public class 소수_찾기 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("143");
    }

    private static class Solution {

        Set<Integer> set = new HashSet<>();

        public int solution(String numbers) {
            int answer = 0;

            String[] split = numbers.split("");

            LinkedList<Integer> numberList = new LinkedList<>();
            for (int i = 0; i < split.length; i++) {
                numberList.add(Integer.parseInt(split[i]));
            }

            count(numberList, 0);

            return set.size();
        }

        public void count(LinkedList<Integer> numbers, int num) {
            if (numbers.isEmpty()) {
                return;
            }

            int size = numbers.size();

            for (int i = 0; i < size; i++) {
                int temp = numbers.remove(i);
                num = num * 10 + temp;

                if (isSosu(num)) {
                    set.add(num);
                }

                count(new LinkedList<>(numbers), num);
                numbers.add(i, temp);
                num = (num - temp) / 10;
            }

        }

        private boolean isSosu(int n) {
            if (n <= 1) {
                return false;
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
