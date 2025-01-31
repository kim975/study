package programmers;

/**
 * 임국심사 : https://school.programmers.co.kr/learn/courses/30/lessons/43238
 */
public class 입국심사 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, new int[] {7, 10});
    }

    private static class Solution {

        public long solution(int n, int[] times) {
            long answer = 0;

            long start = 0;
            long end = 1_000_000_000_000_000_000L;

            while (end > start) {

                long mid = (start + end) / 2;

                if (valid(n, mid, times)) {
                    end = mid;
                } else {
                    start = mid + 1;
                }

            }

            return start;
        }

        public boolean valid(int n, long time, int[] times) {
            long count = 0;

            for (int i = 0; i < times.length; i++) {
                count += time / times[i];
            }
            return count >= n;
        }

    }
}
