package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * 완주하지 못한 선수 : https://school.programmers.co.kr/learn/courses/30/lessons/42576
 */
public class 완주하지_못한_선수 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }

    private static class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";

            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < participant.length; i++) {
                map.put(participant[i], map.getOrDefault(participant[i], 0) + 1);
            }

            for (int i = 0; i < completion.length; i++) {
                map.put(completion[i], map.get(completion[i]) - 1);
            }

            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                if (entry.getValue() != 0) {
                    answer = entry.getKey();
                }
            }

            return answer;
        }
    }

}
