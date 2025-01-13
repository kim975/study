package programmers;

import java.util.LinkedList;
import java.util.List;

/**
 * 수식 최대화
 * https://school.programmers.co.kr/learn/courses/30/lessons/67257
 */
public class 수식_최대화 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution("100-200*300-500+20");
    }

    private static class Solution {

        long max = Long.MIN_VALUE;

        public long solution(String expression) {
            String[] numbers = expression.split("[^0-9]+"); // 숫자만 추출
            String[] operators = expression.split("[0-9]+"); // 연산 기호 추출

            LinkedList<String> expressions = new LinkedList<>();

            expressions.add(numbers[0]);

            for (int i = 1; i < numbers.length; i++) {
                expressions.add(operators[i]);
                expressions.add(numbers[i]);
            }

            calculate(expressions, "");

            return max;
        }

        public void calculate(LinkedList<String> expressions, String expression) {

            String substring = "";
            if (!expression.isEmpty()) {
                substring = expression.substring(expression.length() - 1);
            }

            while (expressions.contains(substring)) {
                int i = expressions.indexOf(substring) - 1;

                long firstNum = Long.parseLong(expressions.remove(i));
                String ex = expressions.remove(i);
                long secondNum = Long.parseLong(expressions.remove(i));

                expressions.add(i, String.valueOf(calculate(firstNum, secondNum, ex)));

            }

            if (expressions.size() == 1) {
                max = Math.max(max, Math.abs(Long.parseLong(expressions.get(0))));
                return;
            }

            if (!expression.contains("*")) {
                calculate(new LinkedList<>(expressions), expression + "*");
            }

            if (!expression.contains("+")) {
                calculate(new LinkedList<>(expressions), expression + "+");
            }

            if (!expression.contains("-")) {
                calculate(new LinkedList<>(expressions), expression + "-");
            }

        }

        public long calculate(long num, long num1, String expression) {

            if (expression.equals("*")) {
                return num * num1;
            } else if (expression.equals("+")) {
                return num + num1;
            } else {
                return num - num1;
            }

        }
    }

}
